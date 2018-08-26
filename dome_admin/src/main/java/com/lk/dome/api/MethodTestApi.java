package com.lk.dome.api;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试普通 HandelMapping 和 HandleAdapt 类
 *
 * @author lkj41110
 */
public class MethodTestApi extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("AnnotationController Working.");
        return new ModelAndView("home");
    }
}
