package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetReplyVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 14:05
 * @version: 1.0
 */
public class GetReplyVo {
    private String content;
    private String time;

    public GetReplyVo() {
    }

    public GetReplyVo(String content, String time) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
