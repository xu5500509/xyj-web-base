package cn.xyj.ssm.base.common.exception;

import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异常处理转化器
 */
public class XyjSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(XyjSimpleMappingExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error("【系统异常】{}", ex);
        String viewName = determineViewName(ex, request);
        if (viewName != null) {// JSP格式返回
            if (!(request.getHeader("accept").indexOf("application/json") > -1
                    || (request.getHeader("X-Requested-With")!= null
                    && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
                // 如果不是异步请求
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getModelAndView(viewName, ex, request);
            } else {// JSON格式返回
                try {
                    response.setHeader("Content-type", "text/json;charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    String jsonString = JSONArray.toJSONString(new BizExceptionHandler().handleException(ex, request));
                    writer.write(jsonString);
                    writer.flush();
                } catch (IOException e) {
                    logger.error("【系统异常】{}", e);
                }
                return null;
            }
        } else {
            return null;
        }
    }
}
