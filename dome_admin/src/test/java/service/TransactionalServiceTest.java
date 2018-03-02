package service;

import com.lk.dome.service.TransactionalService;
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
public class TransactionalServiceTest {
    @Autowired
    private TransactionalService transactionalService;

    @Test
    public void test1() throws Exception {
        transactionalService.test1(true);
    }

    @Test
    public void test2() throws Exception {
        transactionalService.test2(true);
    }

    @Test
    public void test3() throws Exception {
        transactionalService.test3(true);
    }

    @Test
    public void test4() throws Exception {
        transactionalService.test4(true);
    }

    @Test
    public void test5() throws Exception {
        transactionalService.test5(true);
    }
}