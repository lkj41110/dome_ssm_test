package springTest.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class TimeInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            Thread.sleep(1000);
            return methodInvocation.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.toString());
        }
    }
}