package example.controller.shiro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 17-5-27.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String index() {
        System.out.println("登录成功");
        return "/shiro/home";
    }

    @RequestMapping("/home1")
    public String index1() {
        System.out.println("登录成功");
        return "/shiro/home";
    }
}
