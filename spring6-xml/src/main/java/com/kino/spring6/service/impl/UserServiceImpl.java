package com.kino.spring6.service.impl;

import com.kino.spring6.dao.UserDao;
import com.kino.spring6.service.UserService;

/**
 * @author kino
 * @date 2023/7/12 12:24 AM
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
