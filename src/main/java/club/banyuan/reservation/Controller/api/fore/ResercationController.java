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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author HanChao
 * @date 2020-06-22 20:09
 * 描述信息：
 */
@RestController
@RequestMapping(value = "/api/user")
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
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return CommonResult.failed("未登录");
        }
        Integer userId = user.getId();

        // 查看该座位现在是否被预定
        SeatExample example = new SeatExample();
        example.createCriteria().andIdEqualTo(pram.getId()); // seatId
        List<Seat> seatList = seatMapper.selectByExample(example);
        Seat seat = seatList.get(0);
        if (seat.getActived() == 1) {
            return CommonResult.failed("不能预定");
        }

        // 查看该用户是否在冲突的时间预定多个座位
        OrdersExample infoExample = new OrdersExample();
        infoExample.createCriteria().andSeatIdEqualTo(pram.getId()); // seadId
        infoExample.setOrderByClause("id DESC");
        List<Orders> infoList = orderMapper.selectByExample(infoExample);
        Orders orderInfo = infoList.get(0);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Timestamp durationDate = format.format((Timestamp) orderInfo.getDurationAt());
        calendar.setTime(durationDate);
        calendar.add(Calendar.HOUR_OF_DAY,orderInfo.getDuration());
        Timestamp timestamp


        // 预定时长超过8个小时不能预定
        if (pram.getDuration() > 8) {
            return CommonResult.failed("时间太长");
        }

        // 能预定就添加进订单表
        Orders order = new Orders();
        order.setSeatId(seat.getId());
        order.setUserId(userId);
        order.setDuration(pram.getDuration());

        orderMapper.insertSelective(order);
        return CommonResult.success("OK");
    }

    // 取消预定
    @PostMapping(value = "/disres/{id}")
    public CommonResult disRes (@PathVariable(value = "id") Integer seatId,
                                HttpSession session) {
        // 用户是否登录
        // 根据用户Id和座位ID取消预定
        return CommonResult.success("OK");
    }

}
