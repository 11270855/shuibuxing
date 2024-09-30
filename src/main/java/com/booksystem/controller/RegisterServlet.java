package com.booksystem.controller;

import com.booksystem.dao.impl.UserDaoImpl;
import com.booksystem.model.entity.User;
import com.booksystem.service.UserService;
import com.booksystem.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/Register")
public class RegisterServlet extends HttpServlet {
    private final UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        User user=new User();
        user.setCreateTime(LocalDateTime.now());
        user.setNickname(req.getParameter("registerNickName"));
        user.setUsername(req.getParameter("registerUser"));
        user.setPassword(req.getParameter("registerPassword"));
        try {
            user.setGender(Integer.parseInt(req.getParameter("sex")));
        }catch (Exception e){
            e.printStackTrace();
        }
        user.setPermissions(10);
        System.out.println(user);
        userService.insertUser(user);
        out.println("注册成功");
    }
}
