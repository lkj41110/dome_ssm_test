package springTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * spring 资源测试类
 *
 * @author luokai
 * @date 2017/11/30
 */
@Slf4j
public class ResourceTest {

    @Test
    public void testDefaultResourceLoader() {
        /**
         * DefaultResourceLoader
         * getResource来产生产生实例化资源
         * getResourceByPath为模板方法，具体的实现有子类实现
         * 三种判断逻辑，可能会产生没有不存在的资源。
         */
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fakeFileResource = resourceLoader.getResource("/Users/lkj41110/Downloads/programmer/dome_ssm_test/dome_admin/pom.xml");
        assertTrue(fakeFileResource instanceof ClassPathResource);
        //产生的实际上并不存在的资源
        assertFalse(fakeFileResource.exists());
        Resource urlResource1 = resourceLoader.getResource("file:/Users/lkj41110/Downloads/programmer/dome_ssm_test/dome_admin/pom.xml");
        assertTrue(urlResource1 instanceof UrlResource);
        Resource urlResource2 = resourceLoader.getResource("http://www.spring21.cn");
        assertTrue(urlResource2 instanceof UrlResource);
    }

    @Test
    public void testResourceTypesWithFileSystemResourceLoader() {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource fileResource = resourceLoader.getResource("/Users/lkj41110/Downloads/programmer/dome_ssm_test/README");
        assertTrue(fileResource instanceof FileSystemResource);
        Resource urlResource = resourceLoader.getResource("file:/Users/lkj41110/Downloads/programmer/dome_ssm_test/README");
        assertTrue(urlResource instanceof UrlResource);
        assertTrue(urlResource.exists());
    }

    /**
     * ResourcePatternResolver 资源加载器可以加载多个配置文件
     * 不设置默认的加载器，会使用DefaultResourceLoader来加载配置文件
     * 不可在创建的时候指定构造器 PathMatchingResourcePatternResolver(ResourceLoader resourceLoader)
     *
     * @throws IOException
     */
    @Test
    public void testPathMatchingResourcePatternResolver() throws IOException {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        Resource fileResource = resourceResolver.getResource("classpath:jdbc.properties");
        assertTrue(fileResource instanceof ClassPathResource);
        assertTrue(fileResource.exists());

        Resource[] fileResources = resourceResolver.getResources("classpath:*.properties");
        assertTrue(fileResources.length > 0);
    }

    @Test
    public void testApplicationContext() throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-bean.xml");

        //ApplicationContext ctx2 = new FileSystemXmlApplicationContext("conf/appContext.xml");
    }

}
