package com.kino.spring6.controller;

import com.kino.spring6.service.UserService;

/**
 * @author kino
 * @date 2023/7/12 12:23 AM
 */
public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
