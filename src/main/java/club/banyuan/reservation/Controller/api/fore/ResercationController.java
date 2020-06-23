package club.banyuan.reservation.Controller.api.fore;

import club.banyuan.reservation.common.CommonResult;
import club.banyuan.reservation.dto.ResercationPram;
import club.banyuan.reservation.dto.SeatParm;
import club.banyuan.reservation.mapper.OrdersMapper;
import club.banyuan.reservation.mapper.SeatMapper;
import club.banyuan.reservation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HanChao
 * @date 2020-06-22 20:09
 * 描述信息：
 */
@RestController
@RequestMapping(value = "/api/book")
public class ResercationController {

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private OrdersMapper orderMapper;

    @GetMapping(value = "/list")
    public CommonResult seatList () {
        // 查询出座位列表
        List<Seat> seatList = seatMapper.selectByExample(new SeatExample());
        List<SeatParm> list = new ArrayList<>();
        for (Seat s: seatList) {
            SeatParm parm = new SeatParm();
            parm.setId(s.getId());
            parm.setActived(s.getActived());
            list.add(parm);
        }
        return CommonResult.success(list);
    }

    @PostMapping(value = "/res")
    public CommonResult resercation (@RequestBody ResercationPram pram,
                                     HttpSession session) {

        // 判断用户是否登录
        // 获取哪个用户要订座
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            return CommonResult.failed("未登录");
//        }
//        Integer userId = user.getId();
        Integer userId = pram.getUserId();

        // 预定时长超过8个小时不能预定
        if (pram.getDuration() > 8) {
            return CommonResult.failed("时间太长");
        }

        // 查看该座位现在是否被预定
        SeatExample seatExample = new SeatExample();
        seatExample.createCriteria().andIdEqualTo(pram.getId()); // seatId
        List<Seat> seatList = seatMapper.selectByExample(seatExample);
        Seat seat = seatList.get(0);
        if (seat.getActived() == 1 || seat.getRepair() == true) {
            return CommonResult.failed("不能预定");
        }

        // 查看该用户是否在冲突的时间预定座位
        OrdersExample infoExample = new OrdersExample();
        infoExample.createCriteria().andSeatIdEqualTo(pram.getId())     // seadId
                                    .andActivedEqualTo(true);
        infoExample.setOrderByClause("id DESC");
        List<Orders> infoList = orderMapper.selectByExample(infoExample);

        if (infoList.size() > 0) {
            Orders orderInfo = infoList.get(0);

            // 获取座位锁定开始时间
            Timestamp beginTimestamp = (Timestamp) orderInfo.getDurationAt();

            // 结束锁定时间
            Timestamp endTimestamp = beginTimestamp;
            endTimestamp.setHours(orderInfo.getDuration());

            // 用户时间是否与已有订单冲突
            if (Timestamp.valueOf(pram.getDurationAt()).after(beginTimestamp) && Timestamp.valueOf(pram.getDurationAt()).before(endTimestamp)) {
                return CommonResult.failed("时间冲突");
            }
            Timestamp userEndTimestamp = Timestamp.valueOf(pram.getDurationAt());
            userEndTimestamp.setHours(pram.getDuration());
            if (userEndTimestamp.after(beginTimestamp) && userEndTimestamp.before(endTimestamp)) {
                return CommonResult.failed("时间冲突");
            }

            // 用户恶意预定多个座位
            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andUserIdEqualTo(userId);
            ordersExample.setOrderByClause("id DESC");
            List<Orders> ordersList = orderMapper.selectByExample(ordersExample);
            Orders orders = ordersList.get(0);
            if (userEndTimestamp.before(orders.getDurationAt())) {
                return CommonResult.failed("你已有预定");
            }

        }

        // 能预定就添加进订单表
        Orders order = new Orders();
        order.setSeatId(seat.getId());
        order.setUserId(userId);
        order.setDuration(pram.getDuration());
        order.setActived(true);
        order.setDurationAt(Timestamp.valueOf(pram.getDurationAt()));

        orderMapper.insertSelective(order);

//        seat.setActived((byte) 1);
//        seatMapper.updateByExampleSelective(seat,seatExample);

        return CommonResult.success("OK");
    }

    // 取消预定
    @PostMapping(value = "/disres/{id}")
    public CommonResult disRes (@PathVariable(value = "id") Integer seatId,
                                HttpSession session) {
//        // 用户是否登录
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            return CommonResult.failed("未登录");
//        }
//        Integer userId = user.getId();
        Integer userId = 1000;

        // 根据用户Id和座位ID取消预定
        // 先查看有没有预定？
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andSeatIdEqualTo(seatId)
                .andUserIdEqualTo(userId);
        ordersExample.setOrderByClause("id DESC");
        List<Orders> orderList = orderMapper.selectByExample(ordersExample);
        Orders order = orderList.get(0);
        if (order == null || order.getActived() == false) {
            return CommonResult.failed("你未预定");
        }

        OrdersExample example = new OrdersExample();
        example.createCriteria().andSeatIdEqualTo(seatId)
                .andUserIdEqualTo(userId)
                .andActivedEqualTo(true);
        order.setActived(false);
        orderMapper.updateByExampleSelective(order,example);

        return CommonResult.success("OK");
    }

}
