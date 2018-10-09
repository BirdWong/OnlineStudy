package cn.h4795.OnlineStudy.Pojo;

import java.io.Serializable;

public class Personal  implements Serializable {
    private Integer id;

    private String pname;

    private String purl;

    private String psex;

    private String paddress;

    private String pschool;

    private String pcompany;

    private String ppath;

    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl == null ? null : purl.trim();
    }

    public String getPsex() {
        return psex;
    }

    public void setPsex(String psex) {
        this.psex = psex == null ? null : psex.trim();
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress == null ? null : paddress.trim();
    }

    public String getPschool() {
        return pschool;
    }

    public void setPschool(String pschool) {
        this.pschool = pschool == null ? null : pschool.trim();
    }

    public String getPcompany() {
        return pcompany;
    }

    public void setPcompany(String pcompany) {
        this.pcompany = pcompany == null ? null : pcompany.trim();
    }

    public String getPpath() {
        return ppath;
    }

    public void setPpath(String ppath) {
        this.ppath = ppath == null ? null : ppath.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}