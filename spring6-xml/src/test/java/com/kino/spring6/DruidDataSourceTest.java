package com.kino.spring6;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kino
 * @date 2023/7/11 11:26 PM
 */
public class DruidDataSourceTest {
    private static Logger logger = LoggerFactory.getLogger(DruidDataSourceTest.class);
    @Test
    public void test() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-external-prop.xml");
        DruidDataSource druidDataSource = (DruidDataSource) context.getBean("druidDataSource");
        Connection connection = druidDataSource.getConnection();
        logger.info(connection.toString());
    }
}
