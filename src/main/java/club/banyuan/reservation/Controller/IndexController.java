package club.banyuan.reservation.Controller;

import club.banyuan.reservation.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author HanChao
 * @date 2020-06-22 15:49
 * 描述信息：
 */
@Controller
public class IndexController {

    /**
     * 首页
     */
    @GetMapping(value = "/")
    public String index (HttpSession session,
                         Model model) {

//        User user = (User) session.getAttribute("user");
//        model.addAttribute("user",user);
        return "index";
    }

    /**
     * 登录
     */
    @GetMapping(value = "/login")
    public String login () {
        return "login";
    }

    /**
     * 注册
     */
    @GetMapping(value = "/register")
    public String register () { return "register"; }

    /**
     * 注销
     */
    @GetMapping(value = "/logout")
    public String logout (HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    /**
     * 预约历史
     */
    @GetMapping(value = "/history")
    public String history () {
        return "history";
    }

    /**
     * book
     */
    @GetMapping(value = "/book")
    public String book () {
        return "book";
    }
}
