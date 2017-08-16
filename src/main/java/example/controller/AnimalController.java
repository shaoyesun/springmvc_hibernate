package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import example.service.interfacetest.Animal;

/**
 * 示例一个接口多个实现类如何注入问题
 */
@Controller
public class AnimalController {

    //@Resource(name = "dog")
    @Resource(name = "cat")
    private Animal animal;

    @RequestMapping(name = "/animal")
    @ResponseBody
    public String animal() {
        return animal.myName();
    }

}
