package com.cskaoyan.mall.model.redis;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.redis
 * @className: AllUserNameId
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 19:43
 * @version: 1.0
 */
public class AllUserNameId {
    private String nickname;
    private String userId;

    public AllUserNameId() {
    }

    public AllUserNameId(String nickname, String userId) {
        this.nickname = nickname;
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
