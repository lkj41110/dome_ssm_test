package com.lk.dome.service.impl;

import com.lk.dome.dao.TransactionalDao;
import com.lk.dome.service.TransactionalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务测试类
 *
 * @author luokai
 * @date 2018/1/8
 */
@Service
@Slf4j
public class TransactionalServiceImpl implements TransactionalService {
    @Autowired
    private TransactionalDao transactionalDao;

    /**
     * 1.开启事务后 RuntimeException 事务生效
     * 2.开启事务后 Exception 事务生效
     * 3.开启的事务必须和rollbackFor 判断的比较一致才能生效
     * 4.事务可以获取到插入数据库的数据，自增主键也会增加，但是回滚后数据不在数据库，自增会跳过刚刚增加的数
     * 5.同一个类的 B(没有事务)调用A(有事务) 事务无效
     *   B(有事务)调用A(有事务) 事务有效
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int test1(boolean hasException) {
        int a = transactionalDao.test();
        //如果是 hasException
        if (hasException) {
            throw new RuntimeException();
        }
        return a;
    }

    //事务可以获取到插入数据库的数据，自增主键也会增加，但是回滚后数据不在数据库，自增会跳过刚刚增加的数
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int test2(boolean hasException) throws Exception {
        int a = transactionalDao.test();
        log.info("test3:" + a);
        //如果是 hasException
        if (hasException) {
            throw new Exception();
        }
        return a;
    }

    //开启的事务必须和rollbackFor 判断的比较一致才能生效
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int test3(boolean hasException) throws Exception {
        int a = transactionalDao.test();
        //如果是 hasException
        if (hasException) {
            throw new Exception();
        }
        return a;
    }

    //同一个类的 B(没有事务)调用A(有事务) 事务无效
    @Override
    public int test4(boolean hasException) {
        return test4B(hasException);
    }

    @Transactional(rollbackFor = Exception.class)
    private int test4B(boolean hasException) {
        int a = transactionalDao.test();
        //如果是 hasException
        if (hasException) {
            throw new RuntimeException();
        }
        return a;
    }

    //B(有事务)调用A(有事务) 事务有效
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int test5(boolean hasException) {
        return test4B(hasException);
    }



}
