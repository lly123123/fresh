package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("adv")
public class AdvertisementController {

    @RequestMapping("toAdvertisement")
    public String toAdvertisement(){
        return "dyl/advertisement";
    }
}
