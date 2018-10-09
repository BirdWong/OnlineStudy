package cn.h4795.OnlineStudy.Pojo;

import java.io.Serializable;

public class Vidio implements Serializable {
    private Integer id;

    private String vname;

    private String vtext;

    private String vurl;

    private Integer cid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname == null ? null : vname.trim();
    }

    public String getVtext() {
        return vtext;
    }

    public void setVtext(String vtext) {
        this.vtext = vtext == null ? null : vtext.trim();
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl == null ? null : vurl.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}