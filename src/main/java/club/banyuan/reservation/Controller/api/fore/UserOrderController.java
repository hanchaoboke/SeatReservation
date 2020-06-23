package club.banyuan.reservation.Controller.api.fore;

import club.banyuan.reservation.common.CommonResult;
import club.banyuan.reservation.mapper.OrdersMapper;
import club.banyuan.reservation.model.Orders;
import club.banyuan.reservation.model.OrdersExample;
import club.banyuan.reservation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
        if (user == null) {
            return CommonResult.failed("未登录");
        }

        // 查看历史记录
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andUserIdEqualTo(user.getId());
        ordersExample.setOrderByClause("id DESC");
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);

        return CommonResult.success(ordersList);
    }
}
