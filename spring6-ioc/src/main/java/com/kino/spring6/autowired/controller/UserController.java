package com.kino.spring6.autowired.controller;

import com.kino.spring6.autowired.annotation.Bean;
import com.kino.spring6.autowired.annotation.Di;
import com.kino.spring6.autowired.dao.UserDao;

/**
 * @author kino
 * @date 2023/7/13 12:14 AM
 */
@Bean
public class UserController {
    @Di
    private UserDao userDao;
    public void action() {
        userDao.action();
        System.out.println("UserController run...");
    }
}
