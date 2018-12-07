package com.jk.service;

import com.jk.mapper.GoodMapper;
import com.jk.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GoodServiceImpl implements GoodServiceApi {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public Map<String, Object> queryGood(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        long count = goodMapper.queryGoodCount();
        Integer start = (page-1)*rows;
        List<Good> list = goodMapper.queryGoodList(start,rows);
        map.put("total", count);
        map.put("rows", list);
        return map;
    }
}
