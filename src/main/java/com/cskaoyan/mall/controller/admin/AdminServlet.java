package com.cskaoyan.mall.controller.admin;

import com.cskaoyan.mall.model.bo.*;
import com.cskaoyan.mall.model.vo.AdminInfoVo;
import com.cskaoyan.mall.model.vo.AdminLoginVo;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.service.impl.AdminServiceImpl;

import com.cskaoyan.mall.utils.RequestBodyUtil;
import com.cskaoyan.mall.utils.Result;
import com.cskaoyan.mall.utils.StringUtils;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/admin/admin/*")
public class AdminServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();
    Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/admin/admin", "");
        if ("/allAdmins".equals(op)) {
            allAdmins(request, response);
        } else if ("/deleteAdmins".equals(op)) {
            deleteAdmins(request, response);
        }else if ("/getAdminsInfo".equals(op)){
            getAdminsInfo(request,response);
        }
    }

    private void getAdminsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idNum = request.getParameter("id");

        int id = Integer.parseInt(idNum);
        AdminInfoVo adminById = adminService.getAdminById(id);
        response.getWriter().println(gson.toJson(new Result(0, null, adminById)));
    }

    private void deleteAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idNum = request.getParameter("id");

        int id = Integer.parseInt(idNum);
        AdminLoginBo adminLoginBo = (AdminLoginBo) request.getSession().getAttribute("admin");
        Integer adminId = adminService.getAdminId(adminLoginBo);
        if (id != adminId) {
            adminService.deletAdmins(id);
            response.getWriter().println(gson.toJson(new Result(0, null, null)));
        }else {
            response.getWriter().println(gson.toJson(new Result(10000, "无法删除已登录账号", null)));
        }
    }

    private void allAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<AdminInfoVo> adminInfoVoList = adminService.allAdmins();
        Result result = new Result(0, null, adminInfoVoList);
        response.getWriter().println(gson.toJson(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/admin/admin", "");
        if ("/login".equals(op)) {
            login(request, response);
        } else if ("/addAdminss".equals(op)) {
            addAdminss(request, response);
        } else if ("/getSearchAdmins".equals(op)) {
            getSearchAdmins(request, response);
        }else if ("/updateAdminss".equals(op)){
            updateAdminss(request,response);
        }else if ("/changePwd".equals(op)){
            changePwd(request,response);
        }else if ("/logoutAdmin".equals(op)){
            logoutAdmin(request,response);
        }
    }

    private void logoutAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        AdminLoginBo admin = (AdminLoginBo)request.getSession().getAttribute("admin");
        response.getWriter().println(gson.toJson(new Result(0, null, null)));
    }

    private void changePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AdminChangePwdBo adminChangePwdBo = gson.fromJson(requestBody, AdminChangePwdBo.class);
        String adminToken = adminChangePwdBo.getAdminToken();
        String pwd = adminService.getPwdByUsername(adminToken);
        String newPwd = adminChangePwdBo.getNewPwd();
        if ("admin".equals(adminToken)){
            response.getWriter().println(gson.toJson(new Result(10000, "admin不允许修改！", null)));
        }else if (adminChangePwdBo.getOldPwd().equals(newPwd)){
            response.getWriter().println(gson.toJson(new Result(10000, "新旧密码一致，修改失败", null)));
        }else if(!newPwd.equals(adminChangePwdBo.getConfirmPwd())){
            response.getWriter().println(gson.toJson(new Result(10000, "请保持确认新密码一致！", null)));
        }else if (!pwd.equals(adminChangePwdBo.getOldPwd())){
            response.getWriter().println(gson.toJson(new Result(10000, "旧密码输入错误！", null)));
        }else {
            adminService.changePwdByName(adminChangePwdBo);
            response.getWriter().println(gson.toJson(new Result(0, null, null)));
        }
    }

    private void updateAdminss(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AdminUpdateBo adminUpdateBo = gson.fromJson(requestBody, AdminUpdateBo.class);
        adminService.updateAdmin(adminUpdateBo);
        response.getWriter().println(gson.toJson(new Result(0, null, null)));
    }

    //查询管理账户
    private void getSearchAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AdminSearchBo adminSearchBo = gson.fromJson(requestBody, AdminSearchBo.class);
        List<AdminInfoVo> adminInfoVoList = adminService.searchAdmin(adminSearchBo);
        response.getWriter().println(gson.toJson(new Result(0, null, adminInfoVoList)));
    }

    //添加管理账户
    private void addAdminss(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AdminAddBo adminAddBo = gson.fromJson(requestBody, AdminAddBo.class);
        int addCode = adminService.addAdmin(adminAddBo);

        if (addCode == 0) {
            response.getWriter().println(gson.toJson(new Result(addCode, null, null)));
            response.setHeader("refresh", "0.5,url=/api/admin/admin/allAdmins");
        }
        if (addCode == 10000) {
            response.getWriter().println(gson.toJson(new Result(addCode, "该账号不允许重复使用", null)));
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AdminLoginBo adminLoginBo = gson.fromJson(requestBody, AdminLoginBo.class);

        if (StringUtils.isEmpty(adminLoginBo.getEmail()) || StringUtils.isEmpty(adminLoginBo.getPassword())) {
            Result result = new Result(10000, "账号或密码不能为空！", null);
            response.getWriter().println(gson.toJson(result));
        }
        int loginCode = adminService.login(adminLoginBo);
        if (loginCode == 200) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", adminLoginBo);
            Result result = new Result(0, null, new AdminLoginVo(adminLoginBo.getEmail(), adminLoginBo.getEmail()));
            response.getWriter().println(gson.toJson(result));
        } else if (loginCode == 404) {
            Result result = new Result(10000, "账号或密码不正确！", null);
            response.getWriter().println(gson.toJson(result));
        }


    }
}
