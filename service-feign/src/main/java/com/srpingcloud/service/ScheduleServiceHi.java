package com.srpingcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bonismo@hotmail.com
 * 下午11:03 on 17/12/3.
 *
 * @FeignClient
 * 该注解 value 指定 Eureka-Client 模块的 properties 的 name 名字(instance)
 */
@FeignClient(value = "eureka-client")
public interface ScheduleServiceHi {

    /**
     * @RequestMapping 的路由路径对应的是 Eureka-Client 的路由路径
     * 当 Web Controller层 对外暴露 API 时，调用注入的该接口方法，
     * 会通过当前路由调用 Eureka-Client 的服务
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClient(@RequestParam(value = "name") String name);
}
