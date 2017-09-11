package cn.xyj.ssm.base.common.exception;



import cn.xyj.ssm.base.common.Result;
import cn.xyj.ssm.base.common.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 */
public class BizExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(BizExceptionHandler.class);

    public Result handleException(Exception exception, HttpServletRequest request) {
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            return ResultUtil.error(businessException.getErrorCode(), businessException.getMessage());
        }else {
            logger.error("【系统异常】{}", exception);
            return ResultUtil.error("-1", "未知错误");
        }
    }
}
