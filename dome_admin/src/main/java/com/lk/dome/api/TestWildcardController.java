package com.lk.dome.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/wildcard")
public class TestWildcardController {
  
  @RequestMapping("/test/**")
  @ResponseBody
  public ModelAndView test1(ModelAndView view) {
    view.setViewName("/test/test");
    view.addObject("attr", "TestWildcardController -> /test/**");
    return view;
  }
}