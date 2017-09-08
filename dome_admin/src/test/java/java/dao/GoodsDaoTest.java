package java.dao;

import common.config.PropertiesConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
@Slf4j
public class GoodsDaoTest {

    @Test
    public void test1(){
        log.info("asd");
        log.info(PropertiesConfig.getValue("redis.port"));
        log.info(PropertiesConfig.getValue("redis.ip"));
    }
}
