package common.utils;

/**
 * Created by luokai on 2017/7/4.
 * 用来校验参数是否正确的工具类
 */
public class Assert {

    protected Assert() {
    }

    /**
     * 判断参数是否正常
     *
     * @param expression
     * @param message
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**å
     * 判断对象是否为空
     *
     * @param object
     * @param message
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

}