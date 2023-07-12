package com.kino.spring6;

import com.kino.spring6.autowired.context.Spring6AnnotationApplicationContext;
import com.kino.spring6.autowired.controller.UserController;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/7/12 5:42 PM
 */
public class Spring6IocTest {
    @Test
    public void testIoc() throws Exception {
        Spring6AnnotationApplicationContext applicationContext = new Spring6AnnotationApplicationContext("com.kino.spring6");
        UserController userService = (UserController) applicationContext.getBean(UserController.class);
        userService.action();
    }
}
