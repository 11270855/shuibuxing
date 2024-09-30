package com.booksystem.service.impl;

import com.booksystem.dao.UserDao;
import com.booksystem.dao.impl.UserDaoImpl;
import com.booksystem.model.entity.User;
import com.booksystem.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao=new UserDaoImpl();
    @Override
    public void queryAllUser() {
        userDao.selectUser();
    }
    public void insertUser(User user) {
        userDao.addUser(user);
    }
}
