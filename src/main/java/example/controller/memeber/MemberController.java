package example.controller.memeber;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import example.entity.Member;
import example.service.MemberService;

/**
 * 1.spring事务管理实现
 *
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

    @RequestMapping(value = "/getOne")
    @ResponseBody
    public String getOne(Long id) {
        Member m = memberService.getOne(id);
        System.out.println(m.getUsername());
        return null;
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public String findAll() {
        List<Member> list = memberService.findAll();
        return JSONArray.toJSONString(list).toString();
    }


}
