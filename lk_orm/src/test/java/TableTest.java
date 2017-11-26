import com.lk.orm.dao.model.TableColumn;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luokai
 * @date 2017/11/25
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-datasource.xml"})
public class TableTest {
    @Autowired
    private SqlSession sqlSession;

    /*从数据表中获取属性*/
    @Test
    public void TableColumn() {
        Map<String, Object> params = new HashMap();
        //params.put("table", "user_num");
        params.put("table", "test_int");
        List<TableColumn> tableColumns = sqlSession.selectList("ormMapper.TABLE_SCHEMA", params);
        Assert.assertNotNull(tableColumns);
    }

    /* 插入获取主键*/
    @Test
    public void InsertGetIdTest() {
        Map<String, Object> params = new HashMap();
        //params.put("table", "user_num");
        params.put("table", "test_int");
        params.put("sql", "insert into test_int(`user_id`) values ('3211231_123')");
        int id = sqlSession.insert("ormMapper.insert", params);
        System.out.println(params);
        System.out.println(id);
    }
}
