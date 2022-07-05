package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: SpecNameandUserVo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 20:16
 * @version: 1.0
 */
public class SpecNameandUserVo {
    private String specName;
    private Integer userId;
    private String nickName;

    public SpecNameandUserVo() {
    }

    public SpecNameandUserVo(String specName, Integer userId, String nickName) {
        this.specName = specName;
        this.userId = userId;
        this.nickName = nickName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
