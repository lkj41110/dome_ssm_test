package com.lk.dome.api;

import com.lk.dome.service.UtilsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.Result;

/**
 * api 接口测试的接口
 *
 * @author lkj41110
 */
@Controller
@RequestMapping("/api_test")
@Slf4j
public class UtilsTestApi {

    @Autowired
    private UtilsService utilsService;

    @RequestMapping(value = "/utilsTest", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Object> utilsTest() {
        utilsService.utils();
        return Result.success(true);
    }
}
