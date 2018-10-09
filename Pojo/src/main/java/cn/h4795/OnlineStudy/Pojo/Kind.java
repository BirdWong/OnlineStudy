package cn.h4795.OnlineStudy.Pojo;

import java.io.Serializable;

public class Kind implements Serializable {
    private Integer id;

    private String kname;

    private String kdescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname == null ? null : kname.trim();
    }

    public String getKdescription() {
        return kdescription;
    }

    public void setKdescription(String kdescription) {
        this.kdescription = kdescription == null ? null : kdescription.trim();
    }
}