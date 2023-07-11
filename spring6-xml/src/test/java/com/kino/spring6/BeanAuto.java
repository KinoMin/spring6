package com.kino.spring6;


import com.kino.spring6.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kino
 * @date 2023/7/12 12:27 AM
 */
public class BeanAuto {
    @Test
    public void testAutoWireByXML(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-auto.xml");
        UserController userController = ac.getBean(UserController.class);
        userController.saveUser();
    }
}
