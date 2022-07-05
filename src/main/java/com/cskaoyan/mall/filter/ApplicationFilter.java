package com.cskaoyan.mall.filter;

import com.cskaoyan.mall.utils.Result;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/api/admin/*")
public class ApplicationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        HttpServletResponse resp = (HttpServletResponse)response;
        HttpServletRequest req = (HttpServletRequest) request;
        //允许哪些来源的主机访问当前服务器
        resp.setHeader("Access-Control-Allow-Origin", "http://192.168.3.86:8085");
        //访问服务时允许使用的方法
        resp.setHeader("Access-Control-Allow- Methods","POST,GET,OPTIONS,PUT,DELETE");
        //允许携带的头
        resp.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization,Content-Type");
        //是否允许携带cookie的凭证
        resp.setHeader("Access-Control-Allow-Credentials","true");
        String requestURI = req.getRequestURI();
        if (!(req.getContextPath() + "/api/admin/admin/login").equals(requestURI)){
            HttpSession session = req.getSession();
            Object admin = session.getAttribute("admin");
            if (admin == null){
                resp.getWriter().println(new Gson().toJson(new Result(10000,"当前接口仅登陆后可访问",null)));
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
