package cn.h4795.OnlineStudy.Pojo;

import java.io.Serializable;
import java.util.Date;

public class Barrage implements Serializable {
    private Integer id;

    private String btext;

    private Date btime;

    private Integer uid;

    private Integer vid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBtext() {
        return btext;
    }

    public void setBtext(String btext) {
        this.btext = btext == null ? null : btext.trim();
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
}