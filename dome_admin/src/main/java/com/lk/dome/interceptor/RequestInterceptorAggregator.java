package com.lk.dome.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class RequestInterceptorAggregator extends HandlerInterceptorAdapter {

    private List<InterceptorWrapper> userInterceptorWrapper;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    public void setInterceptorList(InterceptorList interceptorList) {
        List<InterceptorWrapper> interceptorWrappers = interceptorList.getInterceptors();
        for (InterceptorWrapper interceptorWrapper : interceptorWrappers) {
            HandlerInterceptorAdapter handlerInterceptorAdapter = interceptorWrapper.getInterceptor();
            System.out.println(handlerInterceptorAdapter);
        }
    }

    public List<InterceptorWrapper> getUserInterceptorWrapper() {
        return userInterceptorWrapper;
    }

    public void setUserInterceptorWrapper(List<InterceptorWrapper> userInterceptorWrapper) {
        this.userInterceptorWrapper = userInterceptorWrapper;
    }
}