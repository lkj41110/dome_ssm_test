package com.lk.orm.dao;

import java.util.Map;

/**
 * @author luokai
 * @date 2017/11/23
 */
public interface BaseDao {
    /**
     * 更新数据
     *
     * @param object
     * @return
     */
    int update(Object object);

    /**
     * 插入数据
     *
     * @param object 插入的对象
     * @return 返回插入数据库的主键ID
     */
    int insert(Object object);

    /**
     * 删除数据
     *
     * @param object
     * @return
     */
    int delete(Object object);

    /**
     * 执行一条自定义的sql语句
     *
     * @param sql
     * @param objs
     * @return
     */
    int execSql(String sql, Map<String, Object> objs);
}
