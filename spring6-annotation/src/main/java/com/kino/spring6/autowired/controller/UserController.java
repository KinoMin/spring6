package com.kino.spring6.autowired.controller;

import com.kino.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author kino
 * @date 2023/7/12 12:41 AM
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void out() {
        userService.out();
        System.out.println("Controller层执行结束。");
    }
}
