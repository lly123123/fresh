package com.jk.service;


import com.jk.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface UserServiceApi {
    @RequestMapping(value = "/queryUser" ,method = RequestMethod.POST)
    List<User> queryUser();
    @RequestMapping(value = "/addUser" ,method = RequestMethod.POST)
    void addUser(@RequestBody User user);

    @RequestMapping(value = "/aa")
    String aa();
}
