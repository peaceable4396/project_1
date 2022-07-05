package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: UserChangePwdBo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 15:57
 * @version: 1.0
 */
public class UserChangePwdBo {
    private String confirmPwd;
    private String id;
    private String newPwd;
    private String oldPwd;

    public UserChangePwdBo() {
    }

    public UserChangePwdBo(String confirmPwd, String id, String newPwd, String oldPwd) {
        this.confirmPwd = confirmPwd;
        this.id = id;
        this.newPwd = newPwd;
        this.oldPwd = oldPwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }
}
