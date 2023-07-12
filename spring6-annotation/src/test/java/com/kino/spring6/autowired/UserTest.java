package com.kino.spring6.autowired;

import com.kino.spring6.autowired.config.Spring6Config;
import com.kino.spring6.autowired.controller.UserController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kino
 * @date 2023/7/12 12:43 AM
 */
public class UserTest {
    private Logger logger = LoggerFactory.getLogger(UserTest.class);
    @Test
    public void testAnnotation(){
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        UserController userController = context.getBean("userController", UserController.class);
        userController.out();
        logger.info("执行成功");
    }
}
