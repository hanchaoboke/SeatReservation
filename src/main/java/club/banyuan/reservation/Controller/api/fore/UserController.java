package club.banyuan.reservation.Controller.api.fore;

import club.banyuan.reservation.common.CommonResult;
import club.banyuan.reservation.dto.UserParam;
import club.banyuan.reservation.mapper.UserMapper;
import club.banyuan.reservation.model.User;
import club.banyuan.reservation.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author HanChao
 * @date 2020-06-22 17:09
 * 描述信息：用户登录相关api
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/login")
    public CommonResult login (@RequestBody UserParam userParam,
                               HttpSession session) {

        // 查询用户是否存在
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userParam.getUsername());
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            return CommonResult.failed("用户不存在");
        }

        // 用户密码是否正确
        User user = userList.get(0);
        if (!user.getPassword().equals(userParam.getPassword())) {
            return CommonResult.failed("用户名或密码错误");
        }


//          如果是管理员？
//        if (user.getFlag() == true) {
//
//        }

        // 用户存进Session
        session.setAttribute("user",user);
        return CommonResult.success("OK");
    }

    @PostMapping(value = "/create")
    public CommonResult create (@RequestBody User user) {

        // 用户名和密码不能为空
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return CommonResult.failed("注册失败!");
        }

        user.setActived(true);
        userMapper.insertSelective(user);
        return CommonResult.success("OK");
    }

}
