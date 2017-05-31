package example.controller.shiro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 17-5-31.
 */
@Controller
public class AminController {

    @RequestMapping(value = "/admin")
    public String admin() {
        return "/shiro/home";
    }

}
