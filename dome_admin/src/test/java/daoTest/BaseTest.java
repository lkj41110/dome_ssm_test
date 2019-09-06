package daoTest;

import com.lk.orm.dao.BaseDao;
import com.lk.orm.dao.model.TableColumn;
import com.lk.orm.mapper.OrmMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author luokai
 * @date 2018/1/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-datasource.xml", "classpath:spring/spring-service.xml"})
public class BaseTest {

    @Autowired
    private BaseDao baseDao;

    @Test
    public void test() {
        System.out.println(baseDao.insert(null));
    }

    @Test
    public void test1() throws IOException {
        String resource = "mybatis/config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            String sql = "test_int";
            OrmMapper mapper = session.getMapper(OrmMapper.class);
            List<TableColumn> tableColumn = mapper.TABLE_SCHEMA(sql);
            System.out.println(tableColumn);
        } finally {
            session.close();
        }
    }
}