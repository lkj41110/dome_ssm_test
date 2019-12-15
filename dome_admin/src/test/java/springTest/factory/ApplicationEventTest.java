package springTest.factory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


/**
 * 事件推送测试
 * @author luokai
 * @date 2017/11/30
 */
@Slf4j
public class ApplicationEventTest {

    @Test
    public void factoryPostProcessorTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-bean2.xml");
        //ctx.registerShutdownHook();
        Bean2 bean = (Bean2) ctx.getBean("bean2");
        bean.sout();

        bean.setAb(1);

        //单利形式
        //Bean2 bean2 = (Bean2) ctx.getBean("bean2");
        //System.out.println(bean2.getAb());

        ctx.close();

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
class AServiceImple implements AService, ApplicationListener {

    public AServiceImple() {
        System.out.println("AServiceImple");
    }

    @Override
    public void run(int aa) {
        System.out.println(aa);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("监听到消息" + applicationEvent);
        if(applicationEvent instanceof ContextClosedEvent){
            System.out.println("我关闭了");
        }
    }
}


@Service
class BServiceImple implements AService,ApplicationListener<ContextRefreshedEvent> {

    public BServiceImple() {
        System.out.println("BServiceImple");
    }

    @Override
    public void run(int aa) {
        System.out.println("123123");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("看开啦");
    }
}
