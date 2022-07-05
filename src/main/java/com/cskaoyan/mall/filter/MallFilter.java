package com.cskaoyan.mall.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/mall/*")
public class MallFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //允许访问的来源的域
        //如果希望浏览器允许携带cookie，服务器需要设置该处为前端页面所在的主机、端口号
        resp.setHeader("Access-Control-Allow-Origin", "http://192.168.3.86:8085");
        //允许发送的请求的方法
        resp.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE");
        //发送请求时允许携带的头
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,Content-Type");
        //是否允许携带cookie的凭证
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request, response);
    }
}
