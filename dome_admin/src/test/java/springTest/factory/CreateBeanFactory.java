package springTest.factory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


/**
 *  循环依赖 测试
 *
 * @author luokai
 * @date 2017/11/30
 */
@Slf4j
public class CreateBeanFactory {

    @Test
    public void getBeanTest() {
        ClassPathResource resource = new ClassPathResource("spring/spring-create.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        BeanA bean = (BeanA) factory.getBean("beanA");
        bean.sout();
    }

    /**
     * 直接内部类
     */
    @Test
    public void getBeanTest2(){
        ClassPathResource resource = new ClassPathResource("spring/spring-create2.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        BeanA bean = (BeanA) factory.getBean("beanA2");
        bean.sout();
    }

}

class BeanA {
    private BeanB beanB;

    public BeanB getBeanB() {
        return beanB;
    }

    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }

    public void sout() {
        beanB.sout();
    }
}

class BeanB {
    private BeanA beanA;

    public BeanA getBeanA() {
        return beanA;
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }

    public void sout() {
        System.out.println("123");
    }
}
