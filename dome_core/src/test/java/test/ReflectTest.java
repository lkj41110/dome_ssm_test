package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by luokai on 2017/7/7.
 */
public class ReflectTest {

    public static void main(String[] args) {
        ReflectTest test = new ReflectTest();
        test.invokeMethodTest();
    }

    /**
     * 获取属性
     */
    private Object getProperty(Object owner, String fieldName) throws Exception {
        Class ownerClass = owner.getClass();
        Field field = ownerClass.getField(fieldName);
        Object property = field.get(owner);
        return property;
    }
    /**
     * 执行方法
     */
    private Object invokeMethod(Object owner, String methodName,Object... args) throws Exception {

        Class ownerClass = owner.getClass();

        Class[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }
        Method method = ownerClass.getDeclaredMethod(methodName, argsClass);
        method.setAccessible(true);
        return method.invoke(owner, args);
    }

    private void getPropertyTest() {
        try {
            ABC abc = new ABC();
            abc.setName("1");
            System.out.print(invokeMethod(abc, "name",new Object[]{"asd"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void invokeMethodTest() {
        try {
            ABC abc = new ABC();
            abc.setName("asd");
            String name = (String)invokeMethod(abc, "statusTest");
            System.out.print(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ABC {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String test(String str){
        return str;
    }

    public String test(){
        return "test";
    }

    private String statusTest(){
        return "status";
    }
}