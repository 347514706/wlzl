package xyz.wlzl.wplzwebjsp.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Title {
    private Integer id;
    private  String title;
    @JSONField(format = "MM-dd HH:mm")
    private Date createTime;
    private String img;
    private Integer falseViews;
    private String titleDesc;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getFalseViews() {
        return falseViews;
    }

    public void setFalseViews(Integer falseViews) {
        this.falseViews = falseViews;
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }
}
