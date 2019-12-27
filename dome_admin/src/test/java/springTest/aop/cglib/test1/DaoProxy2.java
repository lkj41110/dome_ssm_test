package springTest.aop.cglib.test1;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DaoProxy2 implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        System.out.println("Before1 Method Invoke");
        proxy.invokeSuper(object, objects);
        System.out.println("After2 Method Invoke");
        
        return object;
    }
    
}