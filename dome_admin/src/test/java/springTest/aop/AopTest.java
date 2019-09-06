package springTest.aop;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luokai
 * @date 2018/2/21
 */
public class AopTest {

    /**
     * 使用ProxyFactory织入器  织入
     * 编码方式
     */
    @Test
    public void aopTest1UseProxyFactory() {
        ProxyFactory waver = new ProxyFactory(new DaoImpl());

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("select");
        advisor.setAdvice(new TimeInterceptor());

        waver.addAdvisor(advisor);
        //默认使用的jdk动态代理，true时使用CGLIB
        waver.setProxyTargetClass(true);

        DaoImpl dao = (DaoImpl) waver.getProxy();
        System.out.println(dao.getClass());

        /**
         * 使用jdk Proxy动态代理的时候，不能转换为DaoImpl 因为对象继承了Proxy类实现了 对应的接口,
         * 使用CGLIB的时候既可以转换为DaoImpl 也可以转换为Dao
         */
        //Dao dao = (Dao) waver.getProxy();
        dao.select();
        dao.insert();
    }



    /**
     * ProxyFactoryBean 作为织入器
     * xml配置方式
     * ProxyFactoryBean = Proxy + FactoryBean
     * FactoryBean为工厂类Bean，注意和BeanFactory的区别
     */
    @Test
    public void aopTestByProxyFactoryBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-aop.xml");
        //Show dao = (Show) ;
        //dao.add();
        System.out.println(ctx.getBean("mockDao2").getClass());
    }

    /**
     * 利用IOC容器实现集成aop，此时容器为织入器
     */
    @Test
    public void aopTestByIOC() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-aop2.xml");
        Dao dao = (Dao) ctx.getBean("daoImpl");
        dao.select();
    }

    /**
     * 利用DefaultAdvisorAutoProxyCreator 来创建Bean，
     * 会自动找advisor 实现aop
     */
    @Test
    public void aopTestByAutoProxyCreator() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-aop3.xml");
        Show show = (Show) ctx.getBean("showImpl");
        show.add();
    }

    /**
     * xml式事务
     */
    @Test
    public void aopTranstional(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-aop4.xml");
        Show show = (Show) ctx.getBean("showImpl");
        show.add();

    }
}
