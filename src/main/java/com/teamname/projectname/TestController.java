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

    @GetMapping("/test")
    @ResponseBody
    public String test2() {
        return "test";
    }

}
