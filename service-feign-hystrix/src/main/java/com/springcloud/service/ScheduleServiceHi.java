package com.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bonismo@hotmail.com
 * 上午10:19 on 17/12/4.
 */
@FeignClient(value = "eureka-client")
public interface ScheduleServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiService(@RequestParam(value = "name") String name);
}
