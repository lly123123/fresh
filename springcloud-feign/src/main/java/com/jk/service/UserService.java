package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="service-client")
public interface UserService extends UserServiceApi{

    @RequestMapping(value = "/aa")
    String aa();
}
