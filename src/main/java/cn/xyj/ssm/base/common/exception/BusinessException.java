package cn.xyj.ssm.base.common.exception;

/**
 * Created by xuyangjian on 2017/8/28.
 */
public class BusinessException extends Exception {

    private String errorCode;
    private String msg;

    public BusinessException(String errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        msg = msg;
    }
}
