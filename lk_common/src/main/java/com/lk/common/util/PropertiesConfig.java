package com.lk.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Properties;

/**
 * Created by luokai on 2017/7/7.
 * <p>
 * 根据spring读取配置文件的方法。
 * 利用反射调用 mergeProperties 方法，获取配置文件的属性
 */
public class PropertiesConfig {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesConfig.class);

    private static Properties props;
    /**
     * 查询的配置文件的路径
     */
    private static String configPath = "classpath:properties/*.properties";

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
     * 若value为空，则返回defaultValue
     *
     * @param key
     * @param defaultValue 若value为空，则返回defaultValue
     * @return
     */
    public static String getValue(String key, String defaultValue) {
        String value = getValue(key);
        if (value == null) {
            value = defaultValue;
        }
        return value;
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

    /**
     * 若value为空，则返回defaultValue
     *
     * @param key
     * @param defaultValue 若value为空，则返回defaultValue
     * @return
     */
    public static <T> T getValue(String key, Class<T> clazz, T defaultValue) {
        T value = getValue(key, clazz);
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }


    private static void ensureProps() {
        if (props == null) {
            logger.info("ensureProps");
            PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
            PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
            try {
                Resource[] locations = resourceResolver.getResources(configPath);
                propertyConfigurer.setLocations(locations);
                propertyConfigurer.setFileEncoding("utf-8");
///              props = (Properties) CommonUtil.invokeMethod(propertyConfigurer, "mergeProperties");
                props = (Properties) ObjectUtil.invokeMethod(propertyConfigurer, "mergeProperties");
            } catch (Exception e) {
                logger.warn("ensureProps has Exception:{}", e);
                props = new Properties();
            }
        }
    }

    public static String getConfigPath() {
        return configPath;
    }

    public static void setConfigPath(String configPath) {
        PropertiesConfig.configPath = configPath;
    }
}
