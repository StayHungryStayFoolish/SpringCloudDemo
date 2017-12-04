package com.springcloud.service.impl;

import com.springcloud.service.ScheduleServiceHi;
import org.springframework.stereotype.Component;

/**
 * Created by bonismo@hotmail.com
 * 上午10:51 on 17/12/4.
 */
@Component
public class ScheduleServiceHiHystrix implements ScheduleServiceHi {

    @Override
    public String sayHiFromClient(String name) {
        return "Sorry " + name;
    }

}
