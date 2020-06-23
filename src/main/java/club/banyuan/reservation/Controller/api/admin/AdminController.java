package club.banyuan.reservation.Controller.api.admin;

import club.banyuan.reservation.common.CommonResult;
import club.banyuan.reservation.dto.UserParam;
import club.banyuan.reservation.mapper.OrdersMapper;
import club.banyuan.reservation.model.Orders;
import club.banyuan.reservation.model.OrdersExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HanChao
 * @date 2020-06-22 19:42
 * 描述信息：管理员相关api
 */
@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Autowired
    private OrdersMapper ordersMapper;

    @GetMapping(value = "/login")
    public CommonResult adminLogin (@RequestBody UserParam userParam) {

        if (!userParam.getUsername().equals("admin")
                || !userParam.getPassword().equals("123456")) {
            return CommonResult.failed("用户名或密码错误");
        }
        return CommonResult.success("OK");
    }

    @GetMapping(value = "/list")
    public CommonResult adminList () {

        OrdersExample ordersExample = new OrdersExample();
        ordersExample.setOrderByClause("id DESC");
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
        return CommonResult.success(ordersList);
    }
}
