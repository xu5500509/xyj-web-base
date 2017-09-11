package cn.xyj.ssm.domain.Enum;

/**
 * 功能按钮枚举
 */
public enum SqlOrderEnum {
    DESC("desc", "倒序"),
    ASC("asc", "顺序");

    private String action;
    private String name;

    private SqlOrderEnum(String action){
        this.action = action;
    }

    private SqlOrderEnum(String action, String name){
        this.action = action;
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
