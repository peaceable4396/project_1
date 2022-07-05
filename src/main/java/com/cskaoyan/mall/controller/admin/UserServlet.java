package com.cskaoyan.mall.controller.admin;

import com.cskaoyan.mall.model.po.User;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.service.impl.UserServiceImpl;
import com.cskaoyan.mall.utils.Result;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/admin/user/*")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/admin/user", "");
        if ("/allUser".equals(op)) {
            allUser(request, response);
        }else if ("/searchUser".equals(op)){
            searchUser(request,response);
        }else if ("/deleteUser".equals(op)){
            deleteUser(request,response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idNum = request.getParameter("id");
        int id = Integer.parseInt(idNum);
        userService.deletUserById(id);

        response.getWriter().println(gson.toJson(new Result(0,null,null)));
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String word = request.getParameter("word");
        List<User> list = userService.searchUser(word);
        response.getWriter().println(gson.toJson(new Result(0,null,list)));
    }

    private void allUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<User> list = userService.getAllUser();
        response.getWriter().println(gson.toJson(new Result(0,null,list)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
