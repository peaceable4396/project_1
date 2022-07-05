package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetCommentUserVo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 14:12
 * @version: 1.0
 */
public class GetCommentUserVo {
    String nickname;

    public GetCommentUserVo() {
    }

    public GetCommentUserVo(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
