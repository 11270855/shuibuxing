package com.booksystem.controller;

import com.booksystem.utils.CaptchaUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建验证码图片并返回图片上的文本
        response.setContentType("text/html;charset=utf-8");
        String captchaText = CaptchaUtils.createCaptchaImage(request, response);
        // 将验证码文本保存到Session中
//        PrintWriter out = response.getWriter();
//        out.println("231");
        HttpSession session = request.getSession();
        session.setAttribute("captcha", captchaText);
    }
}