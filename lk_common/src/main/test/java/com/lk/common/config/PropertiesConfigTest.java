package com.lk.common.config;


import com.lk.util.PropertiesConfig;
import org.junit.Assert;
import org.junit.Test;

public class PropertiesConfigTest {

	@Test
	public void test() {
        //System.out.println(PropertiesConfig.getValue("test.key1"));


        Assert.assertEquals(PropertiesConfig.getValue("test.key1"), "value1");
		Assert.assertEquals(PropertiesConfig.getValue("test.key2"), "value2");
		
		Assert.assertEquals(PropertiesConfig.getValue("test2.key1"), "test2.value1");

		Assert.assertEquals(PropertiesConfig.getValue("key2"), null);
		//Assert.assertEquals(PropertiesConfig.getValue("key2", "default"), "default");

	}

}
