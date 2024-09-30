package com.booksystem.controller;

import com.booksystem.dao.UserDao;
import com.booksystem.dao.impl.UserDaoImpl;
import com.booksystem.model.entity.User;
import com.booksystem.utils.UserUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        User user = new User();
        user.setUsername(req.getParameter("LoginName"));
        user.setPassword(req.getParameter("LoginPassword"));
        UserDaoImpl userDao = new UserDaoImpl();
        UserUtil userUtil = new UserUtil();
        userUtil=userDao.queryeUser(user);
        if (userUtil.getABoolean()) {
            System.out.println("1----");
            System.out.println(userUtil.getUser().getPassword());
            System.out.println("----2");
            if (userUtil.getUser().getPermissions()==0){
                out.println("<p>管理员登录成功</p>");
            }else out.println("<p>登录成功</p>");
        } else {
            out.println("<p>账号或密码错误</p>");
        }
    }
}

