package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "spring-dyl-client")
public interface GoodService extends GoodServiceApi{
}
