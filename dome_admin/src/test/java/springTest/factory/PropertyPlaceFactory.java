package springTest.factory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 属性注入 Test
 *
 * @author luokai
 * @date 2017/11/30
 */
@Slf4j
public class PropertyPlaceFactory {

    @Test
    public void getBeanTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-propertyPlace.xml");

        PropertyPlaceBean propertyPlaceBean = (PropertyPlaceBean) context.getBean("propertyPlaceBean");
        System.out.println("对象 name:" + propertyPlaceBean.getName());
    }

    /**
     * 属性替换
     * PropertyOverrideConfigurer
     */
    @Test
    public void getBeanTest2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-propertyPlace.xml");

        PropertyPlaceBean2 propertyPlaceBean = (PropertyPlaceBean2) context.getBean("propertyPlaceBean2");
        System.out.println("对象 name:" + propertyPlaceBean.getName1());
    }

}

class CustomPropertyConfig extends PropertyPlaceholderConfigurer {

    private Resource[] locations;

    private PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();

    @Override
    public void setLocations(Resource[] locations) {
        this.locations = locations;
    }

    @Override
    public void setLocalOverride(boolean localOverride) {
        this.localOverride = localOverride;
    }

    /**
     * 覆盖这个方法，根据启动参数，动态读取配置文件
     *
     * @param props
     * @throws IOException
     */
    @Override
    protected void loadProperties(Properties props) throws IOException {
        if (locations != null) {
            // locations 里面就已经包含了那三个定义的文件
            for (Resource location : this.locations) {
                InputStream is = null;
                try {
                    String filename = location.getFilename();
                    String env = "application-" + System.getProperty("spring.profiles.active", "dev") + ".properties";

                    // 找到我们需要的文件，加载
                    if (filename.contains(env)) {
                        logger.info("Loading properties file from " + location);
                        is = location.getInputStream();
                        this.propertiesPersister.load(props, is);
                    }
                } catch (IOException ex) {
                    logger.info("读取配置文件失败.....");
                    throw ex;
                } finally {
                    if (is != null) {
                        is.close();
                    }
                }
            }
        }
    }
}


class PropertyPlaceBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PropertyPlaceBean2 {
    private String name1;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }
}