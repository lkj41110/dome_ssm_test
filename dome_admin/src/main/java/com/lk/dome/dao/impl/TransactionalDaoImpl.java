package com.lk.dome.dao.impl;

import com.lk.dome.dao.TransactionalDao;
import com.lk.orm.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author luokai
 * @date 2018/1/8
 */
@Repository
public class TransactionalDaoImpl implements TransactionalDao {
    @Autowired
    private BaseDao baseDao;

    @Override
    public int test() {
        return baseDao.insert(null);
    }
}
