package com.jk.service;

import com.jk.model.AdvertPlace;
import com.jk.model.Advertisement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface AdvertServiceApi {

    @RequestMapping(value = "/queryAdvertisement",method = RequestMethod.POST)
    Map<String,Object> queryAdvertisement(@RequestParam(value="start")Integer start, @RequestParam(value="pageSize")Integer pageSize, @RequestParam(value="advertisement")Advertisement advertisement);

    @RequestMapping(value = "/queryAdvertPlace",method = RequestMethod.POST)
    Map<String,Object> queryAdvertPlace(@RequestParam(value="start")Integer start, @RequestParam(value="pageSize")Integer pageSize, @RequestParam(value="advertPlace")AdvertPlace advertPlace);


}
