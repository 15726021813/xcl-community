package com.xcl.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 *
 * @author 徐长乐
 * @date 2020/4/30
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String Index(){
        return "index";
    }
}
