package com.lk.orm.dao;

import com.lk.orm.mapper.OrmMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luokai
 * @date 2018/1/8
 */
public class BaseDaoImpl implements BaseDao {

    private SqlSession sqlSession;

    @Override
    public int update(Object object) {
        return 0;
    }

    @Override
    public int insert(Object object) {
        //TODO 生成sql
        Map<String, Object> params = new HashMap();
        //params.put("table", "test_int");
        //params.put("sql", "insert into test_int(`user_id`) values ('3211231_123')");
        //sqlSession.insert("ormMapper.insert", params);
        String sql = "insert into test_int(`user_id`) values ('3211231_123')";
        OrmMapper mapper = sqlSession.getMapper(OrmMapper.class);
        mapper.insert(sql);
        //int primaryId = ((Long) params.get("_iid")).intValue();
        //return primaryId;
        return 0;
    }

    @Override
    public int delete(Object object) {
        return 0;
    }

    @Override
    public int execSql(String sql, Map<String, Object> objs) {
        return 0;
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
}
