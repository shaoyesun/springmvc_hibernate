package example.controller.memeber;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import example.entity.Member;
import example.service.MemberService;

/**
 * Created by root on 17-3-17.
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save() {
        return memberService.save();
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public String findAll() {
        List<Member> list = memberService.findAll();
        return JSONArray.toJSONString(list).toString();
    }


}
