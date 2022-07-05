package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetRepliedMsgBo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 11:00
 * @version: 1.0
 */
public class GetRepliedMsgBo {
    private String content;
    private String createtime;
    GetNoReplyGoodsVo goods;
    private Integer goodsId;
    private Integer id;
    private String replyContent;
    private Integer state;
    GetNoReplyUserVo user;
    private Integer userId;

    public GetRepliedMsgBo() {
    }

    public GetRepliedMsgBo(String content, String createtime, GetNoReplyGoodsVo goods, Integer goodsId, Integer id, String replyContent, Integer state, GetNoReplyUserVo user, Integer userId) {
        this.content = content;
        this.createtime = createtime;
        this.goods = goods;
        this.goodsId = goodsId;
        this.id = id;
        this.replyContent = replyContent;
        this.state = state;
        this.user = user;
        this.userId = userId;
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

    public GetNoReplyGoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GetNoReplyGoodsVo goods) {
        this.goods = goods;
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

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public GetNoReplyUserVo getUser() {
        return user;
    }

    public void setUser(GetNoReplyUserVo user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
