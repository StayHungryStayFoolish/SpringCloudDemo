package com.springcloud.controller;

import com.springcloud.service.ScheduleServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bonismo@hotmail.com
 * 上午10:22 on 17/12/4.
 */
@RestController
public class HiController {

    @Autowired
    private ScheduleServiceHi scheduleServiceHi;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return scheduleServiceHi.sayHiService(name);
    }
}
