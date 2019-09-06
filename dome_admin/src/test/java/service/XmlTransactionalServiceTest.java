package service;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.lk.dome.service.XMLTransactionalService;
import com.lk.dome.service.XMLTransactionalService2;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author luokai
 * @date 2018/1/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring/spring-datasource.xml",
//        "classpath:spring/spring-service.xml","classpath:spring/spring-aop4.xml"})
@ContextConfiguration(locations = {"classpath:spring/spring-datasource.xml",
        "classpath:spring/spring-service.xml"})
public class XmlTransactionalServiceTest {
    @Autowired
    private XMLTransactionalService xmlTransactionalService;
    @Autowired
    private XMLTransactionalService2 xmlTransactionalService2;
    @Autowired
    private BasicDataSource dataSource;

    /**
     * 事务的
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        xmlTransactionalService2.addTest2(true);
    }

    /**
     * 模仿 not_support传播方式
     * @throws SQLException
     */
    @Test
    public void test2() throws SQLException {

        PreparedStatement pstmtupdate = null;
        PreparedStatement pstmtquery = null;
        String updatesql = "insert into test_int(`user_id`) values ('2')";
        String querysql = "查询sql";
        DruidPooledConnection conn = dataSource.getConnection();
        try {
            conn.setAutoCommit(false); // 自动提交设置为false

            // 执行更新操作
            pstmtupdate = conn.prepareStatement(updatesql);
            pstmtupdate.execute(updatesql);
            test3();
            int i = 1 / 0;

            // 执行查找操作
            //pstmtquery = conn.prepareStatement(querysql);
            //pstmtquery.executeQuery();

            conn.commit();
            conn.setAutoCommit(true);

            pstmtupdate.close();
            //pstmtquery.close();
            conn.close();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstmtupdate != null) {
                    pstmtupdate.close();
                }

                if (pstmtquery != null) {
                    pstmtquery.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
            }

        }

    }

    private void test3() throws SQLException {
        PreparedStatement pstmtupdate = null;
        PreparedStatement pstmtquery = null;
        String updatesql = "insert into test_int(`user_id`) values ('3')";
        String querysql = "查询sql";
        DruidPooledConnection conn = dataSource.getConnection();

        // 执行更新操作
        pstmtupdate = conn.prepareStatement(updatesql);
        pstmtupdate.execute(updatesql);
    }
}