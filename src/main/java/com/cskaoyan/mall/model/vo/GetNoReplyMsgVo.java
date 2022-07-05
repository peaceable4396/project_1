package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetNoReplyMsg
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 15:09
 * @version: 1.0
 */
public class GetNoReplyMsgVo {
    private String content;
    private String createtime;
    private Integer goodsId;
    private Integer id;
    private Integer state;
    private Integer userId;
    private GetNoReplyGoodsVo goods;
    private GetNoReplyUserVo user;

    public GetNoReplyMsgVo() {
    }

    public GetNoReplyMsgVo(String content, String createtime, Integer goodsId, Integer id, Integer state, Integer userId, GetNoReplyGoodsVo goods, GetNoReplyUserVo user) {
        this.content = content;
        this.createtime = createtime;
        this.goodsId = goodsId;
        this.id = id;
        this.state = state;
        this.userId = userId;
        this.goods = goods;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public GetNoReplyGoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GetNoReplyGoodsVo goods) {
        this.goods = goods;
    }

    public GetNoReplyUserVo getUser() {
        return user;
    }

    public void setUser(GetNoReplyUserVo user) {
        this.user = user;
    }
}
