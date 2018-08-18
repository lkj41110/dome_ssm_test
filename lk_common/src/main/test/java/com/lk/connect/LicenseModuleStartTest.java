package com.lk.connect;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Author: jiyanbin@betamail.net
 * Date: 13:58
 * JDK: 1.7
 */
//@ContextConfiguration(locations = "classpath:/META-INF/spring/dsat-license-import-test.xml")
public class LicenseModuleStartTest {

    @BeforeClass
    public static void setup() {
        URL.setURLStreamHandlerFactory(new LcnServerStubURLStreamHandlerFactory());
    }
    @Test
    public void test1(){
        URL url;
        try {
            url = new URL("ghb://www.baidu.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            System.out.println(httpURLConnection);//输出：com.yzp.net.http.HttpURLConnectionImpl:http://www.baidu.com
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
