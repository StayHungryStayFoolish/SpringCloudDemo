package com.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bonismo@hotmail.com
 * 下午1:54 on 17/12/4.
 */
@Component
public class MyFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("This is a pre filter , it will throw a RuntimeException !");
        System.out.println("===========");
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            doSomething();
        } catch (Exception e) {
            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception",e);
        }
//        HttpServletRequest request = ctx.getRequest();
//        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
//        Object accessToken = request.getParameter("token");
//        if (accessToken == null) {
//            logger.warn("Token is empty");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            try {
//                ctx.getResponse().getWriter().write("Token is empty");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
        logger.info("Ok !------------------------");
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors ...");
    }
}

/**
 * filterType: 返回一个字符串代表过滤器的类型，在 zuul 中定义了四种不同生命周期的过滤器类型
 * <p>
 * pre  路由之前
 * routing 路由之时
 * post 路由之后
 * error 发送错误调用
 * filterOrder 过滤的顺序
 * shouldFilter 可以写逻辑判断，是否要过滤，true 永远过滤
 * run 过滤器具体逻辑。包括 sql,nosql 判断到底有没有权限访问
 */