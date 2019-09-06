package com.lk.dome.service.impl;

import com.lk.dome.service.XMLTransactionalService;
import com.lk.dome.service.XMLTransactionalService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author luokai
 * @description:
 * @date: 2019/7/17
 * @version: 1.0
 */
@Service
@Slf4j
public class XMLTransactionalService2Impl implements XMLTransactionalService2 {

    @Autowired
    private XMLTransactionalService xmlTransactionalService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int addTest2(boolean hasException) {
        log.info("开始 addTest2");
        return xmlTransactionalService.addTest(true);
    }
}
