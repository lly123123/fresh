package com.jk.controller;

import com.jk.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @RequestMapping("queryGood")
    @ResponseBody
    public Map<String, Object> queryGood(Integer page,Integer rows){
        Map<String, Object> map=goodService.queryGood(page,rows);
        return map;
    }



}
