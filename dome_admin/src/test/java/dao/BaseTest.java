package daoTest;

import com.lk.orm.dao.BaseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author luokai
 * @date 2018/1/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class BaseTest {

    @Autowired
    private BaseDao baseDao;

    @Test
    public void test() {
        System.out.println(baseDao.insert(null));
    }
}
