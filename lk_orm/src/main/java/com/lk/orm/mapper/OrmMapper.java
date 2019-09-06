package com.lk.orm.mapper;

import com.lk.orm.dao.model.TableColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author luokai
 * @description:
 * @date: 2019/8/30
 * @version: 1.0
 */
public interface OrmMapper {

    List<TableColumn> TABLE_SCHEMA(@Param("table") String table);


    void insert(@Param("sql") String sql);

}
