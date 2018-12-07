package com.jk.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface GoodServiceApi {

    @RequestMapping(value = "/queryGood",method = RequestMethod.POST)
    Map<String,Object> queryGood(@RequestParam(value="page")Integer page,@RequestParam(value="rows")Integer rows);
}
