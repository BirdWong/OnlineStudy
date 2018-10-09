package entity;

import java.io.Serializable;

/**
 *  结果返回
 * @author Administrator
 * @date 2018/7/21 0021
 */
public class Result implements Serializable {


    //是否成功
    private  boolean success;

    //返回信息
    private String massage;

    public Result(boolean success, String massage) {
        this.success = success;
        this.massage = massage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
