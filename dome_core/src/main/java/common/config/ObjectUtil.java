package common.config;

import java.lang.reflect.Method;

/**
 * Created by luokai on 2017/7/11.
 * 和反射有关的方法
 */
public class ObjectUtil {
    /**
     * 反射执行方法
     */
    public static Object invokeMethod(Object owner, String methodName, Object... args) throws Exception {
        Class ownerClass = owner.getClass();
        Class[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }
        Method method = getMethod(ownerClass, methodName, argsClass);
        method.setAccessible(true);
        return method.invoke(owner, args);
    }

    /**
     * 获取方法，找不到时从
     *
     * @param clazz
     * @param methodName
     * @param classes
     * @return
     * @throws Exception
     */
    private static Method getMethod(Class clazz, String methodName,
                                    final Class[] classes) throws Exception {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName, classes);
        } catch (NoSuchMethodException e) {
            if (clazz.getSuperclass() == null) {
                return method;
            } else {
                method = getMethod(clazz.getSuperclass(), methodName,
                        classes);
            }

        }
        return method;
    }

    /**
     * 将值转换成相应的值
     */
    public static <T> T convertValue(Object value, Class<T> clazz) {

        if (value == null) return null;

        String param = value.toString().trim();
        if (param.trim().equals("")) {
            return null;
        }
        //TODO
        if (clazz == String.class) return (T) param;
        return (T) value;
    }
}
