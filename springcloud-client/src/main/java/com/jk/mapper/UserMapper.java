package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component("userMapper")
public interface UserMapper {
    List<User> queryUser();

    void addUser(User user);
}
