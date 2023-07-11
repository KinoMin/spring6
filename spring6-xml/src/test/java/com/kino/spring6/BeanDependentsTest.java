package com.kino.spring6;

import com.kino.spring6.bean.Clazz;
import com.kino.spring6.bean.Teacher;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kino
 * @date 2023/7/11 11:07 PM
 */
public class BeanDependentsTest {
    private static Logger logger = LoggerFactory.getLogger(BeanDependentsTest.class);
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-di-dependents.xml");
        Teacher teacher = context.getBean("teacher",Teacher.class);
        Clazz clazz = context.getBean("clazz",Clazz.class);
        logger.info(teacher.toString());
        logger.info(clazz.toString());


        Teacher teacher2 = (Teacher)context.getBean("teacher2");
        logger.info(teacher2.toString());
    }
}
