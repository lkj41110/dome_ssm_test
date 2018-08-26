package com.lk.dome.service.impl;

import com.lk.dome.service.UtilsService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 测试spring 注入map的
 *
 * @author luokai
 * @date 2018/8/23
 */
@Service
public class UtilsServiceImpl implements UtilsService {

    private Map<String, Integer> map;

    @Override
    public void utils() {
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey());
        }
        ;
    }
}
