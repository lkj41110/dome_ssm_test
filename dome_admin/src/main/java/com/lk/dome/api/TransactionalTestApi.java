package com.lk.dome.api;

import com.lk.dome.service.TransactionalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.Result;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 事务测试 api
 *
 * @author lkj41110
 */
@Controller
@RequestMapping("/transactional_test")
@Slf4j
public class TransactionalTestApi {

    @Autowired
    private TransactionalService transactionalService;

    @RequestMapping(value = "/transactionalTest", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Integer> transactionalTest(boolean flag) throws InterruptedException {
        return Result.success(transactionalService.test6(flag));
    }


    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("aa", "aa");
        map.put("adsf", "a3");
        map.put("adsf2", "a1");
        map.put("adsf1", "a3");

        Set set = map.keySet();
        for (Object set1 : set) {
            map.get(set1);
        }
    }
}
