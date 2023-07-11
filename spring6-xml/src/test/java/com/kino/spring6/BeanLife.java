package com.kino.spring6;

import com.kino.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kino
 * @date 2023/7/12 12:16 AM
 */
public class BeanLife {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-life.xml");
        User bean = context.getBean(User.class);
        System.out.println("生命周期：4、通过IOC容器获取bean并使用");
        context.close();
    }
}
