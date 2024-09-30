package com.booksystem.dao;

import com.booksystem.model.entity.User;
import com.booksystem.utils.UserUtil;

public interface UserDao {
    void addUser(User user);
    void selectUser();
    UserUtil queryeUser(User user);
}
