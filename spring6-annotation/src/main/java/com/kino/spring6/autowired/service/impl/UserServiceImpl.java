package com.kino.spring6.autowired.service.impl;

import com.kino.spring6.autowired.dao.UserDao;
import com.kino.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author kino
 * @date 2023/7/12 12:39 AM
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired // 属性注入
    @Qualifier("userDaoImpl") // Autowired 和 Qualifier 联合注解, 指定bean的名字
    private UserDao userDao;

    @Autowired // set 注入
    public void setUserDao(@Autowired UserDao userDao) { // 形参上注入
        this.userDao = userDao;
    }

    @Autowired // 构造方法 注入, 如果构造器就只有需要注入的属性, 可以省略 @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void out() {
        userDao.print();
        System.out.println("Service层执行结束");
    }
}
