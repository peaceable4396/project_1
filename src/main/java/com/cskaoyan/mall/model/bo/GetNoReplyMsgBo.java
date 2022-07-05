package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: GetNoReplyMsgBo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 10:51
 * @version: 1.0
 */
public class GetNoReplyMsgBo {
    private String content;
    private Integer id;

    public GetNoReplyMsgBo() {
    }

    public GetNoReplyMsgBo(String content, Integer id) {
        this.content = content;
        this.id = id;
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
}
