package xyz.wlzl.wplzwebjsp.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Active {
    private Integer id;
    private  String title;
    @JSONField(format = "MM-dd HH:mm")
    private Date createTime;
    private Integer isVip;
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
