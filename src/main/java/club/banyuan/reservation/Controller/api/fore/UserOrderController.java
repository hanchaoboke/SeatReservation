package club.banyuan.reservation.Controller.api.fore;

import club.banyuan.reservation.common.CommonResult;
import club.banyuan.reservation.utils.Source;
import club.banyuan.reservation.dto.UserHistoryPram;
import club.banyuan.reservation.dto.position;
import club.banyuan.reservation.mapper.OrdersMapper;
import club.banyuan.reservation.model.Orders;
import club.banyuan.reservation.model.OrdersExample;
import club.banyuan.reservation.model.User;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HanChao
 * @date 2020-06-22 19:44
 * 描述信息：
 */
@RestController
@RequestMapping(value = "/api/order")
public class UserOrderController {

    @Autowired
    private OrdersMapper ordersMapper;

    @GetMapping(value = "/history/{id}")
    public CommonResult history (@PathVariable(value = "id") Integer userId,
                                 HttpSession session) {
        // 判断用户是否登录
        User user = (User) session.getAttribute("user");
        if (user == null || !user.getId().equals(userId)) {
            return CommonResult.failed("未登录");
        }

        // 查看历史记录
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andUserIdEqualTo(user.getId());
        ordersExample.setOrderByClause("id DESC");
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);

        List<UserHistoryPram> historyPramList = new ArrayList<>();

        for (Orders s: ordersList) {
            UserHistoryPram pram = new UserHistoryPram();
            pram.setId(s.getId());
            pram.setUserId(s.getUserId());
            pram.setPositionId(s.getSeatId());
            pram.setCancelFlag(s.getActived());
            pram.setCreatedAt(DateUtil.format(s.getCreatedAt(), Source.FORMAT_yMd_Hms));
            pram.setUpdatedAt(DateUtil.format(s.getDurationAt(),Source.FORMAT_yMd_Hms));
            pram.setHour(s.getDuration());
            position pos = new position();
            pos.setName(s.getSeatId()+"号座位");
            pram.setPosition(pos);

        }

        return CommonResult.success(historyPramList);
    }
}
