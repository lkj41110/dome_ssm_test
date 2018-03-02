package apitest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author luokai
 * @date 2017/11/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
//用来获取web环境侧的上下文
@WebAppConfiguration
public class GoodsApiTest {

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext; //注入web环境的ApplicationContext容器

    @Before
    public void init() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //
    }

    //测试
    @Test
    public void failTest() throws Exception {
        mockMvc.perform(get("/main_test/logTest"))//执行请求
                .andExpect(status().isOk());

        /**
         *  也是用了断言来判断状态吗是否是5XX
         */
        mockMvc.perform(get("/main_test/logTest"))//执行请求
                .andExpect(status().is2xxSuccessful());
    }

    //测试
    @Test
    public void failTest2() throws Exception {
        MvcResult result = mockMvc.perform(get("/main_test/logTest"))//执行请求
                .andReturn(); //返回MvcResult

        System.out.println(result); //result里存放了mockRequest和mockResponse;
    }

    @Test
    public void configTest() throws Exception {
        //PropertiesConfig.setConfigPath("classpath:properties/*.properties");
        MvcResult result = mockMvc.perform(get("/main_test/configTest"))//执行请求
                .andReturn(); //返回MvcResult
    }


}
