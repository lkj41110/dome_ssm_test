package springTest.factory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


/**
 * init 方法测试
 *
 * @author luokai
 * @date 2017/11/30
 */
@Slf4j
public class InitMethodBeanFactory {

    @Test
    public void getBeanTest() {
        ClassPathResource resource = new ClassPathResource("spring/spring-initmethod.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        InitMethodBean bean = (InitMethodBean) factory.getBean("initMethodBean");
    }

}

class InitMethodBean implements InitializingBean {

    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBeanTest initializing...");
        this.name = "chenssy 2 号";
    }

    public void initMethod(){
        System.out.println("InitializingBeanTest initMethod22222...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
