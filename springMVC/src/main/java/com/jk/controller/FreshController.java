package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fresh")
public class FreshController {
    @RequestMapping("a")
    public String a(){
        return "index";
    }
}
