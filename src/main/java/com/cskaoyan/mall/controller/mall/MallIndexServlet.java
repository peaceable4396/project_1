package com.cskaoyan.mall.controller.mall;

import com.cskaoyan.mall.model.po.GoodType;
import com.cskaoyan.mall.model.po.Goods;
import com.cskaoyan.mall.model.po.Spec;
import com.cskaoyan.mall.model.vo.GetGoodsByTypeVo;
import com.cskaoyan.mall.model.vo.HomepageGoodVo;
import com.cskaoyan.mall.service.GoodService;
import com.cskaoyan.mall.service.MallService;
import com.cskaoyan.mall.service.impl.GoodServiceImpl;
import com.cskaoyan.mall.service.impl.MallServiceImpl;
import com.cskaoyan.mall.utils.RequestBodyUtil;
import com.cskaoyan.mall.utils.Result;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/mall/index/*")
public class MallIndexServlet extends HttpServlet {
    MallService mallService = new MallServiceImpl();
    GoodService goodService = new GoodServiceImpl();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/mall/index", "");
        if ("/getType".equals(op)) {
            getType(request, response);
        }
    }


    private void getType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<GoodType> list = mallService.getAllType();
        response.getWriter().println(gson.toJson(new Result(0, null, list)));
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
