package springTest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-bean.xml");
        Bean bean = (Bean) ctx.getBean("bean");
        bean.sout();
    }


}

class Bean {
    public void sout() {
        System.out.println("sout");
    }
}

@Data
class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    private int aValue = 100;
    private int bValue = 200;

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {

        System.out.println("调用MyBeanFactoryPostProcessor的postProcessBeanFactory");
        BeanDefinition bd = beanFactory.getBeanDefinition("myBeanFactoryPostProcessor");
        MutablePropertyValues pv = bd.getPropertyValues();
        System.out.println(pv);

    }

}

class MyBeanPsotProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before bean" + bean);
        System.out.println("before beanName" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after bean" + bean);
        System.out.println("after beanName" + beanName);
        return bean;
    }
}
