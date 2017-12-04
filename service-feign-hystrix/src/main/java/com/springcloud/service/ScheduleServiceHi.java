package com.springcloud.service;

import com.springcloud.service.impl.ScheduleServiceHiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bonismo@hotmail.com
 * 上午10:19 on 17/12/4.
 *
 * Feign 开启断路器，只需要在 service 层的接口，加上 fallback 指定当前接口实现类
 */
@FeignClient(value = "eureka-client",fallback = ScheduleServiceHiHystrix.class)
public interface ScheduleServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClient(@RequestParam(value = "name") String name);
}
