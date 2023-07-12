package com.kino.spring6.autowired.dao.impl;

import com.kino.spring6.autowired.annotation.Bean;
import com.kino.spring6.autowired.dao.UserDao;

/**
 * @author kino
 * @date 2023/7/13 12:21 AM
 */
@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void action() {
        System.out.println("UserDao run...");
    }
}
