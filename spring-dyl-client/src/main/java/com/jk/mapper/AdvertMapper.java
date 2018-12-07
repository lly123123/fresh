package com.jk.mapper;

import com.jk.model.AdvertPlace;
import com.jk.model.Advertisement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdvertMapper {

    long queryAdvertisementCount(@Param("adv") Advertisement advertisement);

    List<Advertisement> queryAdvertisementList(@Param("start")Integer start, @Param("pageSize")Integer pageSize, @Param("adv")Advertisement advertisement);

    long queryAdvertPlaceCount(@Param("advp") AdvertPlace advertPlace);

    List<AdvertPlace> queryAdvertPlaceList(@Param("start")Integer start, @Param("pageSize")Integer pageSize, @Param("advp")AdvertPlace advertPlace);
}
