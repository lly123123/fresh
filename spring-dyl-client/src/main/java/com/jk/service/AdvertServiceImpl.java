package com.jk.service;

import com.jk.mapper.AdvertMapper;
import com.jk.model.AdvertPlace;
import com.jk.model.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdvertServiceImpl implements AdvertServiceApi{

    @Autowired
    private AdvertMapper advertMapper;

    @Override
    public Map<String, Object> queryAdvertisement(Integer start, Integer pageSize, Advertisement advertisement) {
        Map<String, Object> map = new HashMap<>();
        long count = advertMapper.queryAdvertisementCount(advertisement);
        List<Advertisement> list = advertMapper.queryAdvertisementList(start,pageSize,advertisement);
        map.put("total", count);
        map.put("rows", list);
        return map;
    }

    @Override
    public Map<String, Object> queryAdvertPlace(Integer start, Integer pageSize, AdvertPlace advertPlace) {
        Map<String, Object> map = new HashMap<>();
        long count = advertMapper.queryAdvertPlaceCount(advertPlace);
        List<AdvertPlace> list = advertMapper.queryAdvertPlaceList(start,pageSize,advertPlace);
        map.put("total", count);
        map.put("rows", list);
        return map;
    }
}
