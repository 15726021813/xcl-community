package com.xcl.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * helloController
 *
 * @author 徐长乐
 * @date 2020/4/30
 */
@Controller
public class helloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name , Model model){
        model.addAttribute("name",name);
        return "hello";

    }
}
