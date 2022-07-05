package com.cskaoyan.mall.controller.mall;

import com.cskaoyan.mall.model.bo.*;
import com.cskaoyan.mall.model.po.User;
import com.cskaoyan.mall.model.vo.GetUserDataVo;
import com.cskaoyan.mall.model.vo.UserSignupVo;
import com.cskaoyan.mall.service.MallUserService;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.service.impl.MallUserServiceImpl;
import com.cskaoyan.mall.utils.RequestBodyUtil;
import com.cskaoyan.mall.utils.Result;
import com.cskaoyan.mall.utils.StringUtils;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/api/mall/user/*")
public class MallUserServlet extends HttpServlet {
    Gson gson = new Gson();
    MallUserService mallUserService = new MallUserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/mall/user", "");
        if ("/data".equals(op)) {
            data(request, response);
        }
    }

    private void data(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("token");
        User user = mallUserService.getUserByEmail(email);
        GetUserDataVo userDataVo = new GetUserDataVo(user.getAddress(), 0, user.getEmail(), user.getId().toString(), user.getNickname(),
                user.getPhone(), user.getRecipient());
        response.getWriter().println(gson.toJson(Result.ok(userDataVo)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/mall/user", "");
        if ("/signup".equals(op)) {
            signup(request, response);
        } else if ("/login".equals(op)) {
            login(request, response);
        } else if ("/updatePwd".equals(op)) {
            updatePwd(request, response);
        } else if ("/updateUserData".equals(op)) {
            updateUserData(request, response);
        }
    }

    private void updateUserData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserUpdateBo userUpdateBo = gson.fromJson(requestBody, UserUpdateBo.class);
        if (StringUtils.isEmpty(userUpdateBo.getAddress())){
            response.getWriter().println(gson.toJson(Result.error("收货地址不能为空！")));
            return;
        }else if (StringUtils.isEmpty(userUpdateBo.getRecipient())){
            response.getWriter().println(gson.toJson(Result.error("收件人不能为空！")));
            return;
        }else if (StringUtils.isEmpty(userUpdateBo.getPhone())){
            response.getWriter().println(gson.toJson(Result.error("收件人电话不能为空！")));
            return;
        }
        mallUserService.updateUser(userUpdateBo);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void updatePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserChangePwdBo userChangePwdBo = gson.fromJson(requestBody, UserChangePwdBo.class);
        Integer userId = Integer.parseInt(userChangePwdBo.getId());
        String pwd = mallUserService.getPwdByuserId(userId);
        String oldPwd = userChangePwdBo.getOldPwd();
        String newPwd = userChangePwdBo.getNewPwd();
        String confirmPwd = userChangePwdBo.getConfirmPwd();
        if (oldPwd.equals(newPwd)) {
            response.getWriter().println(gson.toJson(Result.error("新旧密码一致，修改失败")));
        } else if (!newPwd.equals(confirmPwd)) {
            response.getWriter().println(gson.toJson(Result.error("请保持确认新密码一致！")));
        } else if (!pwd.equals(oldPwd)) {
            response.getWriter().println(gson.toJson(Result.error("旧密码输入错误！")));
        } else if (StringUtils.isEmpty(newPwd)) {
            response.getWriter().println(gson.toJson(Result.error("密码不能为空！")));
        } else {
            mallUserService.changePwdByUserId(userId, newPwd);
            response.getWriter().println(gson.toJson(Result.ok()));
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserLoginBo userLoginBo = gson.fromJson(requestBody, UserLoginBo.class);
        String userLoginBoEmail = userLoginBo.getEmail();
        String userLoginBoPwd = userLoginBo.getPwd();
        if (StringUtils.isEmpty(userLoginBoEmail) || StringUtils.isEmpty(userLoginBoPwd)) {
            response.getWriter().println(gson.toJson(Result.error("用户名不能为空")));
            return;
        }
        String pwd = mallUserService.getUserByName(userLoginBoEmail);
        if (StringUtils.isEmpty(pwd)) {
            response.getWriter().println(gson.toJson(Result.error("账号或密码输入错误")));
            return;
        }
        if (pwd.equals(userLoginBoPwd)) {
            request.getSession().setAttribute("username", userLoginBoEmail);
            response.getWriter().println(gson.toJson(Result.ok(new UserSignupVo(0, userLoginBoEmail, userLoginBoEmail))));
        }
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserSignupBo userSignupBo = gson.fromJson(requestBody, UserSignupBo.class);

        int addCode = mallUserService.addUser(userSignupBo);
        if (addCode == 10000) {
            response.getWriter().println(gson.toJson(Result.error("该用户名已存在！")));
            return;
        }
        UserSignupVo userSignupVo = new UserSignupVo(addCode, userSignupBo.getEmail(), userSignupBo.getEmail());
        response.getWriter().println(gson.toJson(new Result(addCode, null, userSignupVo)));
    }
}
