package com.cskaoyan.mall.model.vo;

import java.util.Timer;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetGoodsMessageVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 14:03
 * @version: 1.0
 */
public class GetGoodsMessageVo {
    private String asker;
    private String content;
    private Integer id;
    private String time;
    GetReplyVo reply;

    public GetGoodsMessageVo() {
    }

    public GetGoodsMessageVo(String asker, String content, Integer id, String time, GetReplyVo reply) {
        this.asker = asker;
        this.content = content;
        this.id = id;
        this.time = time;
        this.reply = reply;
    }

    public String getAsker() {
        return asker;
    }

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public GetReplyVo getReply() {
        return reply;
    }

    public void setReply(GetReplyVo reply) {
        this.reply = reply;
    }
}
