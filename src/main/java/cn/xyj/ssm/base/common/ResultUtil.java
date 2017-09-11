package cn.xyj.ssm.base.common;


/**
 * 2017-01-21 13:39
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode("1");
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
