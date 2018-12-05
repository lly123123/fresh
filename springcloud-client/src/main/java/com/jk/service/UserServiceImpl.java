package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserServiceImpl implements UserServiceApi {
  @Autowired
  private UserMapper userMapper;


  @Override
  @RequestMapping(value="/queryUser")
  public List<User> queryUser() {
    return userMapper.queryUser();
  }

    @Override
    @RequestMapping(value="/addUser")
    public void addUser(@RequestBody User user) {
        userMapper.addUser(user);
    }

  @Override
  public String aa() {
    return "1";
  }


}
