package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetNoReplyUserVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 15:17
 * @version: 1.0
 */
public class GetNoReplyUserVo {
    private String name;

    public GetNoReplyUserVo() {
    }

    public GetNoReplyUserVo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

