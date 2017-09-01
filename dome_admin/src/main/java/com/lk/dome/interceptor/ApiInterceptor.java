package com.lk.dome.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wanglei on 16/5/6.
 * 处理跨域问题
 */
public class ApiInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(ApiInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        if (!response.containsHeader("Access-Control-Allow-Origin")) {
            response.addHeader("Access-Control-Allow-Origin", "*");
        }
        if (!response.containsHeader("Access-Control-Allow-Credentials")) {
            response.addHeader("Access-Control-Allow-Credentials", "true");
        }
        if (!response.containsHeader("Access-Control-Allow-Methods")) {
            response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        }
        return true;
    }
}
