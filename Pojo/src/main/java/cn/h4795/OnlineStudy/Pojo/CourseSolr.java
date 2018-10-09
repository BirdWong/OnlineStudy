package cn.h4795.OnlineStudy.Pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

public class CourseSolr implements Serializable {

    @Field
    private Long id;

    @Field("course_name")
    private String cname;

    @Field("course_url")
    private String curl;

    @Field("course_description")
    private String cdescription;

    @Field("course_user")
    private String  user;

    @Field("course_kind")
    private String kind;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCurl() {
		return curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
}