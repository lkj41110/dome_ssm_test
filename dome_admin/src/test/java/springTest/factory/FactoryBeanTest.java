package springTest.factory;


/**
 * @author luokai
 * @date 2018/7/15
 */
public class FactoryBeanTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-bean2.xml");
        String bean = (String) ctx.getBean("myFactoryBean");

        System.out.println(bean);
    }

}

class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        System.out.println("factory Bean");
        return new String("111");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}