package com.kino.spring6.dao.impl;

import com.kino.spring6.dao.UserDao;

/**
 * @author kino
 * @date 2023/7/12 12:25 AM
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
