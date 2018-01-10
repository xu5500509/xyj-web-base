package cn.xyj.ssm.aop.log;

import cn.xyj.ssm.domain.Servicelog;
import cn.xyj.ssm.service.IServicelogService;
import com.alibaba.fastjson.JSONObject;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by xuyangjian on 2018/1/9.
 */
@Aspect
@Component
public class SystemLogAspect {
    @Autowired
    private IServicelogService logService;

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    // Service层切点
    @Pointcut("@annotation(cn.xyj.ssm.aop.log.SystemServiceLog)")
    public void serviceAspect() {
    }
    // Controller层切点
    @Pointcut("@annotation(cn.xyj.ssm.aop.log.SystemControllerLog)")
    public void controllerAspect() {
    }
    /**
     * 活动数据变更完成后更新日志
     * @param joinPoint
     * @param returnVal
     */
    @AfterReturning(pointcut = "controllerAspect()",returning = "returnVal")
    public void doAfterController(JoinPoint joinPoint, Object returnVal){
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ip = request.getRemoteAddr();
            //Account user = WebContext.getCurrentUser(request);
            /**获取用户请求方法的参数并序列化为JSON格式字符串**/
            String mainParams = getControllerMethodDescription(joinPoint,2);
            String params = "";
            if(StringUtils.isNotBlank(mainParams)){
				/*JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);*/
                String[] paramArray = mainParams.split(",");
                for (int i = 0; i < paramArray.length; i++) {
                    if(Integer.parseInt(paramArray[i])<joinPoint.getArgs().length){
                        if(isBaseData(joinPoint.getArgs()[Integer.parseInt(paramArray[i])])){
                            params += joinPoint.getArgs()[Integer.parseInt(paramArray[i])] + ";";
                        }else{
                            if (joinPoint.getArgs()[Integer.parseInt(paramArray[i])] instanceof Object[]){
                                params += StringUtils.join((Object[]) joinPoint.getArgs()[Integer.parseInt(paramArray[i])], ",") + ";";
                            }else {
                                    params += JSONObject.toJSONString(joinPoint.getArgs()[Integer.parseInt(paramArray[i])]) + ";";
                            }
                        }
                    }
                }
            }
            if(returnVal!=null){
                JSONObject json = (JSONObject) JSONObject.toJSON(returnVal);
                logger.info("controller接口返回值："+ json.get("resultMsg").toString());
            }
            Servicelog log = new Servicelog();
            log.setLogDescription(getControllerMethodDescription(joinPoint,1));
            log.setLogParams(params);
            log.setLogTime(new Date());
            log.setLogMethod(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            log.setLogType(0);
            log.setLogIp(ip.toString());
            logService.add(log);
        }catch(Exception e){
            logger.error("日志切面异常信息:{}", e);
        }
    }

    public boolean isBaseData(Object param){
        if(param instanceof String || param instanceof Integer || param instanceof Byte || param instanceof Double || param instanceof Float
                || param instanceof Long || param instanceof Boolean || param instanceof Date){
            return true;
        }
        return false;
    }
    /**
     * 异常通知 用于拦截service层记录异常日志
     * @param joinPoint
     * @param e
     */
	/*@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		// 读取session中的用户
		User user = (User) session.getAttribute(WebConstants.CURRENT_USER);
		// 获取请求ip
		String ip = request.getRemoteAddr();
		// 获取用户请求方法的参数并序列化为JSON格式字符串
		String params = "";
		if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
			for (int i = 0; i < joinPoint.getArgs().length; i++) {
				params += JSONUtil.toJsonString(joinPoint.getArgs()[i]) + ";";
			}
		}
		try {
			 ========控制台输出=========
			System.out.println("=====异常通知开始=====");
			System.out.println("异常代码:" + e.getClass().getName());
			System.out.println("异常信息:" + e.getMessage());
			System.out.println("异常方法:"
					+ (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
			System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));
			System.out.println("请求人:" + user.getName());
			System.out.println("请求IP:" + ip);
			System.out.println("请求参数:" + params);
			 ==========数据库日志=========
			Log log = SpringContextHolder.getBean("logxx");
			log.setDescription(getServiceMthodDescription(joinPoint));
			log.setExceptionCode(e.getClass().getName());
			log.setType("1");
			log.setExceptionDetail(e.getMessage());
			log.setMethod(
					(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
			log.setParams(params);
			log.setCreateBy(user);
			log.setCreateDate(DateUtil.getCurrentDate());
			log.setRequestIp(ip);
			// 保存数据库
			logService.add(log);
			System.out.println("=====异常通知结束=====");
		} catch (Exception ex) {
			// 记录本地异常日志
			logger.error("==异常通知异常==");
			logger.error("异常信息:{}", ex.getMessage());
		}
		 ==========记录本地异常日志==========
		logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}",
				joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(),
				e.getMessage(), params);
	}*/
    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param joinPoint 切点
     * @param type 扩展值选择（1：description，2：mainParams，3：bussinessId）
     * @return 方法注解描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint,int type) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        //获取方法参数名称
        String[] paramNames =  getMethodParamNames(targetClass, targetName, methodName);
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    if(type == 1){
                        description = method.getAnnotation(SystemControllerLog.class).description();
                    }else if (type == 2){
                        description = method.getAnnotation(SystemControllerLog.class).mainParams();
                    }else if (type == 3){
                        description = method.getAnnotation(SystemControllerLog.class).bussinessId();
                    }
                    break;
                }
            }
        }
        return description;
    }


    private static String[] getMethodParamNames(Class cls, String clazzName, String methodName) throws NotFoundException {
        //实例化类型池对象 默认搜索jvm同路径下的class
        ClassPool classPool = ClassPool.getDefault();
        //设置类搜索路径
        ClassClassPath classClassPath = new ClassClassPath(cls);
        classPool.insertClassPath(classClassPath);

        //获取指定类型
        CtClass cc = classPool.get(clazzName);
        //获取指定方法名称
        CtMethod cm = cc.getDeclaredMethod(methodName);
        //获取此方法的文件
        MethodInfo methodInfo = cm.getMethodInfo();
        //获取方法代码属性
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
        }
        String[] paramNames = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramNames.length; i++){
            paramNames[i] = attr.variableName(i + pos); //paramNames即参数名
        }
        return paramNames;
    }
}
