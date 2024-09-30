package com.booksystem.controller;

import com.booksystem.dao.UserDao;
import com.booksystem.dao.impl.UserDaoImpl;
import com.booksystem.service.UserService;
import com.booksystem.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl() {
    };
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.queryAllUser();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
