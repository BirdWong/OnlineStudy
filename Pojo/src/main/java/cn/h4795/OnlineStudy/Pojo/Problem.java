package cn.h4795.OnlineStudy.Pojo;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/8/8 0008
 */
public class Problem implements Serializable {

	private Integer kid ;

	private String question;

	private String answer;

	private Map choice;

	private Integer grade;

	private Integer uid;

	private Integer qid;

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Map getChoice() {
		return choice;
	}

	public void setChoice(Map choice) {
		this.choice = choice;
	}

}
