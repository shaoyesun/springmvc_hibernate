package example.controller.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import example.entity.shiro.User;
import example.service.shiro.UserService;

/**
 * Created by root on 17-5-27.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //跳转到登录页面
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        // 跳转到/page/login.jsp页面
        return "/shiro/login";
    }

    //实现用户登录
    @RequestMapping(value = "/login")
    public String Login(String username, String password, RedirectAttributes model) {
        User user = userService.getUserByUserName(username);
        if (user == null) {
            model.addFlashAttribute("msg", "用户不存在");
            return "redirect:/toLogin";
        }
        if (!user.getPassword().equals(password)) {
            model.addFlashAttribute("msg", "账号密码错误");
            return "redirect:/toLogin";
        }
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
        // 登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return "redirect:/home";
    }
}
