package com.jk.mapper;

import com.jk.model.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodMapper {

    @Select(" select count(*) from t_goods ")
    long queryGoodCount();

    @Select(" select * from  t_goods limit #{start},#{rows} ")
    List<Good> queryGoodList(@Param("start") Integer start, @Param("rows") Integer rows);


}
