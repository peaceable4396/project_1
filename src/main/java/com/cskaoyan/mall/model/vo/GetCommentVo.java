package com.cskaoyan.mall.model.vo;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetCommentVo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 20:33
 * @version: 1.0
 */
public class GetCommentVo {
    private List<GetCommentsVo> commentList;
    private String rate;

    public GetCommentVo() {
    }

    public GetCommentVo(List<GetCommentsVo> commentList, String rate) {
        this.commentList = commentList;
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public List<GetCommentsVo> getList() {
        return commentList;
    }

    public void setList(List<GetCommentsVo> list) {
        this.commentList = list;
    }
}
