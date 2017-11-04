package com.lk.dome.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.Result;

/**
 * @author lkj41110
 */
@Controller
@RequestMapping("/main_test")
@Slf4j
public class GoodsController {


    @RequestMapping(value = "/failTest", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> fail() {
        log.error("enter fail ");
        log.error("enter fail2");
        return Result.fail(100, "失败");
    }

    @RequestMapping(value = "/logTest", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> logTest() {
        log.debug("debug");
        log.info("info");
        log.warn("warm");
        log.error("error");
        log.trace("trace");
        return Result.success(null);
    }

    @RequestMapping(value = "/exceptionText", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Integer> exceptionText(){
        int i = 1 / 0;
        return Result.success(i);
    }
}
