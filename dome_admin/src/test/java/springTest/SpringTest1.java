package springTest;

import com.yingjun.ssm.model.domain.Goods;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luokai on 2017/8/24.
 */
public class SpringTest1 {

    @Test
    public void testSimpleLoad() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring/spring-test.xml"));
        Goods goods = (Goods) bf.getBean("goods");
        System.out.println(goods);
    }


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

    @Test
    public void encode() throws Exception {
        //String str="123iam英雄;;";
        String str1 = "汉";
        byte[] a = str1.getBytes("UTF-16");
        List<Byte> b = new ArrayList<Byte>();
        for (int i = 0; i < a.length; i++) {
            b.add(a[i]);
        }
        b.stream().forEach(e-> System.out.println(Integer.toHexString(e)));


    }
}
