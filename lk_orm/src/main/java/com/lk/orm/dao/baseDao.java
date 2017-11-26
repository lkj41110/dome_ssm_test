package com.lk.orm.dao;

/**
 * @author luokai
 * @date 2017/11/23
 */
public interface baseDao {
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
     * @param object
     * @return
     */
    int insert(Object object);

    /**
     * 删除数据
     *
     * @param object
     * @return
     */
    int delete(Object object);
}
