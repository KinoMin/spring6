package com.kino.spring6;

import com.kino.spring6.bean.HelloWorld;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kino
 * @date 2023/7/11 5:55 PM
 */
public class HelloWorldTest {
    private Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 根据 id 获取
        HelloWorld bean1 = (HelloWorld) context.getBean("helloworld");

        // 根据类型获取
        // 当根据类型获取bean时，要求IOC容器中指定类型的bean有且只能有一个, 以下配置会报错
        // <bean id="helloworldOne" class="com.kino.spring6.bean.HelloWorld"></bean>
        // <bean id="helloworldTwo" class="com.kino.spring6.bean.HelloWorld"></bean>
        HelloWorld bean2 = context.getBean(HelloWorld.class);

        // 根据 id 和 类型获取
        HelloWorld bean3 = context.getBean("helloworld", HelloWorld.class);

        bean1.sayHello();
        logger.info("执行成功");
    }
}
