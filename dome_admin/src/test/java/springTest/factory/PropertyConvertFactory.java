package springTest.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.converter.Converter;
import springTest.factory.domain.BaseBean;

/**
 * @author luokai
 * @description:
 * @date: 2019-12-21
 * @version: 1.0
 */
public class PropertyConvertFactory {

    @Test
    public void getBeanTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-property-convert.xml");
        BaseBean propertyPlaceBean = (BaseBean) context.getBean("baseBean");
        System.out.println("对象 name:" + propertyPlaceBean.getName());
    }


}

class StudentConversionService implements Converter<String,String> {


    @Override
    public String convert(String source) {
        return source;
    }
}