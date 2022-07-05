package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetCommentsVo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 14:10
 * @version: 1.0
 */
public class GetCommentsVo {
    private String comment;
    private Integer id;
    private Integer score;
    private String specName;
    private String time;
    private GetCommentUserVo user;
    private Integer userId;

    public GetCommentsVo() {
    }

    public GetCommentsVo(String comment, Integer id, Integer score, String specName, String time, GetCommentUserVo user, Integer userId) {
        this.comment = comment;
        this.id = id;
        this.score = score;
        this.specName = specName;
        this.time = time;
        this.user = user;
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public GetCommentUserVo getUser() {
        return user;
    }

    public void setUser(GetCommentUserVo user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
