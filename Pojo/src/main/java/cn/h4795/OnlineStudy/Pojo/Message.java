package cn.h4795.OnlineStudy.Pojo;

import java.io.Serializable;

public class Message  implements Serializable {
    private Integer id;

    private String mtext;

    private Integer getid;

    private Integer sendid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMtext() {
        return mtext;
    }

    public void setMtext(String mtext) {
        this.mtext = mtext == null ? null : mtext.trim();
    }

    public Integer getGetid() {
        return getid;
    }

    public void setGetid(Integer getid) {
        this.getid = getid;
    }

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }
}