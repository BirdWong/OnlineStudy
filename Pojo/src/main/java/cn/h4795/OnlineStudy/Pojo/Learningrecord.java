package cn.h4795.OnlineStudy.Pojo;

import java.util.Date;

public class Learningrecord {
    private Integer id;

    private Date studytime;

    private Integer cid;

    private Integer uid;

    private Integer kid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStudytime() {
        return studytime;
    }

    public void setStudytime(Date studytime) {
        this.studytime = studytime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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