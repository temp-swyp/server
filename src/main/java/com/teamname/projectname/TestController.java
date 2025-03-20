package com.teamname.projectname;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/")
    @ResponseBody
    public String test() {
        return "hello";
    }

    @GetMapping("/loginTest")
    @ResponseBody
    public String test2() {
        return "로그인 성공 야호!";
    }

}
