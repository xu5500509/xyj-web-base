package cn.xyj.ssm.aop.log;

import java.lang.annotation.*;

/**
 * Controller操作日志收集器
 * Created by xuyangjian on 2018/1/9.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
    String description() default "";

    String mainParams() default "";

    String bussinessId() default "";
}
