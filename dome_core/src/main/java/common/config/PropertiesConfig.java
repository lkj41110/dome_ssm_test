package common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Properties;

/**
 * Created by luokai on 2017/7/7.
 * 根据spring读取配置文件的方法。
 * 利用反射调用 mergeProperties 方法，获取配置文件的属性
 */
@Slf4j
public class PropertiesConfig {
    private static Properties props;

    /**
     * 获取key的属性值
     *
     * @param key
     * @return
     */
    public static String getValue(String key) {
        return getValue(key, String.class);
    }

    /**
     * 获取key的属性值
     *
     * @param <T>
     * @param key
     * @return
     */
    public static <T> T getValue(String key, Class<T> clazz) {
        ensureProps();
        String k = props.getProperty(key);
        return ObjectUtil.convertValue(k, clazz);
    }

    private static void ensureProps() {
        if (props == null) {
            PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
            PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
            try {
                Resource[] locations = resourceResolver.getResources("classpath*:**/*.properties");
                propertyConfigurer.setLocations(locations);
                propertyConfigurer.setFileEncoding("utf-8");
//              props = (Properties) CommonUtil.invokeMethod(propertyConfigurer, "mergeProperties");
                props = (Properties) ObjectUtil.invokeMethod(propertyConfigurer, "mergeProperties");
            } catch (Exception e) {
                log.warn("ensureProps has Exception:{}", e);
                props = new Properties();
            }
        }
    }

}
