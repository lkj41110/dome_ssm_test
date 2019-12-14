package springTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


/**
 * 注意BeanFactoryPostProcessor 和 BeanPostProcessor两个是不同的接口
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
