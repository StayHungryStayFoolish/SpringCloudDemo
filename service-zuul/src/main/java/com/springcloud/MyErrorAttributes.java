//package com.springcloud;
//
//import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
//import org.springframework.web.context.request.RequestAttributes;
//
//import java.util.Map;
//
///**
// * Created by bonismo@hotmail.com
// * 下午10:14 on 17/12/6.
// */
//public class MyErrorAttributes extends DefaultErrorAttributes {
//
//    @Override
//    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
//        Map<String, Object> result = super.getErrorAttributes(requestAttributes, includeStackTrace);
//        result.remove("exception");
//        return result;
//    }
//}
