package springTest.aop.cglib.test1;

import org.junit.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

public class CglibTest {

    @Test
    public void testCglib() {
        DaoProxy daoProxy = new DaoProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoProxy);

        Dao dao = (Dao) enhancer.create();
        dao.update();
        dao.select();
    }

    @Test
    public void testCglib2() {
        DaoProxy daoProxy = new DaoProxy();
        DaoProxy2 daoProxy2 = new DaoProxy2();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{daoProxy, daoProxy2});
        enhancer.setCallbackFilter(new DaoFilter());


        Dao dao = (Dao) enhancer.create();
        dao.update();
        dao.select();
    }

}