package com.kino.spring6;

import com.kino.spring6.bean.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kino
 * @date 2023/7/11 10:52 PM
 */
public class StudentTest {
    private static Logger logger = LoggerFactory.getLogger(StudentTest.class);
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-di.xml");
        Student student1 = (Student) context.getBean("student");
        logger.info(student1.toString());

        Student student2 = (Student)context.getBean("studentTwo");
        logger.info(student2.toString());
    }
}
