package cn.h4795.OnlineStudy.Pojo;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable{
    private Integer id;

    private Date createdata;

    private Integer score;

    private String purl;

    private String aswer;

    private String description;

    private Integer uid;

    private Integer kid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedata() {
        return createdata;
    }

    public void setCreatedata(Date createdata) {
        this.createdata = createdata;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl == null ? null : purl.trim();
    }

    public String getAswer() {
        return aswer;
    }

    public void setAswer(String aswer) {
        this.aswer = aswer == null ? null : aswer.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }
}