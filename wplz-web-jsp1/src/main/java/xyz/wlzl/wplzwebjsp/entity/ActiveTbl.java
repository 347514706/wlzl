package xyz.wlzl.wplzwebjsp.entity;

import java.io.Serializable;
import java.util.Date;

public class ActiveTbl  implements Serializable{
    private Integer id;
    private  String title;
    private Date createTime;
    private Integer isVip;
    private Integer issue;
    private Integer userId;
    private String trueViews;
    private String falseViews;
    private String activeDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getIssue() {
        return issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTrueViews() {
        return trueViews;
    }

    public void setTrueViews(String trueViews) {
        this.trueViews = trueViews;
    }

    public String getFalseViews() {
        return falseViews;
    }

    public void setFalseViews(String falseViews) {
        this.falseViews = falseViews;
    }

    public String getActiveDesc() {
        return activeDesc;
    }

    public void setActiveDesc(String activeDesc) {
        this.activeDesc = activeDesc;
    }


}
