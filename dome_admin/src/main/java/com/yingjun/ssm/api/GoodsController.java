package com.yingjun.ssm.api;

import com.yingjun.ssm.model.domain.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.Result;

@Controller
@RequestMapping("/main_test")
@Slf4j
public class GoodsController {

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Goods> test() {
        Goods goods = new Goods();
        goods.setId("1");
        goods.setName("a");
        return Result.success(goods);
    }

    @RequestMapping(value = "/failTest", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> fail() {
        return Result.fail("100", "失败");
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

}
