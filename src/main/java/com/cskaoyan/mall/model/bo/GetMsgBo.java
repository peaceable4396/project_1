package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: GetMsgBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 14:47
 * @version: 1.0
 */
public class GetMsgBo {
    private String goodsId;
    private String msg;
    private String token;

    public GetMsgBo() {
    }

    public GetMsgBo(String goodsId, String msg, String token) {
        this.goodsId = goodsId;
        this.msg = msg;
        this.token = token;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
