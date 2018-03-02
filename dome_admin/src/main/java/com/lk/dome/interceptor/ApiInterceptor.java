package com.lk.dome.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by on 16/5/6.
 * 处理跨域问题
 */
@Slf4j
public class ApiInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("=========== enter ApiInterceptor =======");
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
