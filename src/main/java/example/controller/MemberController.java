package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.service.MemberService;

/**
 * Created by root on 17-3-17.
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        return memberService.test();
    }

}
