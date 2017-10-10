package springTest;

import org.junit.Test;
import org.springframework.util.ClassUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Created by luokai on 2017/8/24.
 */
public class SpringTest1 {

    @Test
    public void test() {
        String url = "spring/spring-test.xml";
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(url);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        } catch (Exception e) {

        }
    }
}
