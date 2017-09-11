package cn.xyj.ssm.base;

/**
 * Created by xuyangjian on 2017/2/16.
 */
public class BaseDomain <T> implements java.io.Serializable {
    private static final long serialVersionUID = 6667600871541308622L;
    private T id;

    public BaseDomain() { /* compiled code */ }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}