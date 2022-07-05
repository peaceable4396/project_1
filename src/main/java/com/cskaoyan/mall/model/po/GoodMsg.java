package com.cskaoyan.mall.model.po;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.po
 * @className: GoodMsg
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 9:58
 * @version: 1.0
 */
public class GoodMsg {
    private Integer id;
    private String content;
    private String replyContent;
    private String goods;
    private String username;
    private String createTime;
    private String replyTime;
    private Integer state;
    private Integer userId;
    private Integer goodsId;

    public GoodMsg() {
    }

    public GoodMsg(Integer id, String content, String replyContent, String goods, String username, String createTime, String replyTime, Integer state, Integer userId, Integer goodsId) {
        this.id = id;
        this.content = content;
        this.replyContent = replyContent;
        this.goods = goods;
        this.username = username;
        this.createTime = createTime;
        this.replyTime = replyTime;
        this.state = state;
        this.userId = userId;
        this.goodsId = goodsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
