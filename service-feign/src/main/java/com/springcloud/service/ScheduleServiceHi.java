package com.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bonismo@hotmail.com
 * 上午2:36 on 17/12/3.
 *
 * @FeignClient(valeu = "服务中心所注册的服务客户端名称")
 * localhost:8761 页面显示
 * 即： eurekaclient 配置文件上的 name 属性大写
 *
 * 当 controller 层对外暴露服务的 API 时，会调用该方法 sayHiFromClient
 * 自动进入 EUREKA-CLIENT 的实例中，调用实例中对外暴露的服务方法 hi，
 * 从而产生一次消费。
 */
@FeignClient(value = "EUREKA-CLIENT")
public interface ScheduleServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClient(@RequestParam(value = "name") String name);

}

