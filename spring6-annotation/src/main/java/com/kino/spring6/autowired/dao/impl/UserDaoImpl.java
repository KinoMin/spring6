package com.kino.spring6.autowired.dao.impl;

import com.kino.spring6.autowired.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author kino
 * @date 2023/7/12 12:38 AM
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void print() {
        System.out.println("Dao层执行结束");
    }
}
