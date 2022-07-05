package com.cskaoyan.mall.model.bo;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: CarBo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 17:45
 * @version: 1.0
 */
public class CartsBo {
    private List<CartBo> cartList;

    public List<CartBo> getList() {
        return cartList;
    }

    public void setList(List<CartBo> list) {
        this.cartList = list;
    }
}
