package com.lk.dome.service.impl;

import com.lk.dome.dao.TransactionalDao;
import com.lk.dome.service.XMLTransactionalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luokai
 * @description:
 * @date: 2019/7/14
 * @version: 1.0
 */
@Service
@Slf4j
public class XMLTransactionalServiceImpl implements XMLTransactionalService {
    @Autowired
    private TransactionalDao transactionalDao;

    @Override
    //@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    //@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public int addTest(boolean hasException) {
        log.info("addTest1");
        int i = transactionalDao.test();
        //i = 1 / 0;
        return i;
    }
}
