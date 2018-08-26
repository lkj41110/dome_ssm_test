package springTest.factory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


/**
 * 注意BeanFactoryPostProcessor 和 BeanPostProcessor两个是不同的接口
 *
 * @author luokai
 * @date 2017/11/30
 */
@Slf4j
public class BeanFactoryPostProcessorTest {

    @Test
    public void factoryPostProcessorTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-bean2.xml");
        Bean2 bean = (Bean2) ctx.getBean("bean2");
        bean.sout();

        bean.setAb(1);

        //单利形式
        //Bean2 bean2 = (Bean2) ctx.getBean("bean2");
        //System.out.println(bean2.getAb());

    }


}

class Bean2 {

    @Autowired
    private AService bService;

    private int aa;

    private int ab = 0;

    public Bean2(int aa) {
        this.aa = aa;
    }

    public void sout() {
        bService.run(aa);
    }

    public AService getaService() {
        return bService;
    }

    public void setaService(AService aService) {
        this.bService = aService;
    }

    public int getAb() {
        return ab;
    }

    public void setAb(int ab) {
        this.ab = ab;
    }
}

interface AService {
    void run(int aa);
}

@Service
class AServiceImple implements AService, ApplicationListener<ContextRefreshedEvent> {

    public AServiceImple() {
        System.out.println("AServiceImple");
    }

    @Override
    public void run(int aa) {
        System.out.println(aa);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("监听到消息" + event);
    }
}


@Service
class BServiceImple implements AService {

    public BServiceImple() {
        System.out.println("BServiceImple");
    }

    @Override
    public void run(int aa) {
        System.out.println("123123");
    }
}
