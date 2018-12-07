package com.jk.controller;

import com.jk.model.AdvertPlace;
import com.jk.model.Advertisement;
import com.jk.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("adv")
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    /**
     * 广告查询
     * @param start
     * @param pageSize
     * @param advertisement
     * @return
     */
    @RequestMapping("/queryAdvertisement")
    @ResponseBody
    public Map<String, Object> queryAdvertisement(Integer start, Integer pageSize, Advertisement advertisement){
        Map<String, Object> map = advertService.queryAdvertisement(start,pageSize,advertisement);
        return map;
    }

    /**
     * 广告位查询
     * @param start
     * @param pageSize
     * @param queryAdvertPlace
     * @return
     */
    @RequestMapping("/queryAdvertPlace")
    @ResponseBody
    public Map<String, Object> queryAdvertPlace(Integer start, Integer pageSize, AdvertPlace advertPlace){
        Map<String, Object> map = advertService.queryAdvertPlace(start,pageSize,advertPlace);
        return map;
    }

}
