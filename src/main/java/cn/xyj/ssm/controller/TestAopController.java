package cn.xyj.ssm.controller;

import cn.xyj.ssm.aop.log.SystemControllerLog;
import cn.xyj.ssm.domain.User;
import cn.xyj.ssm.domain.UserEx;
import cn.xyj.ssm.service.IUserService;
import cn.xyj.ssm.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 测试aop controller
 */
@Controller
@RequestMapping({"/aop"})
public class TestAopController {

    Logger logger = LoggerFactory.getLogger(TestAopController.class);

    @Autowired
    IUserService userService;


    @RequestMapping("testAop1")
    @ResponseBody
    @SystemControllerLog(description = "测试日志1")
    public Map<String, Object> testAop1(Long id) throws Exception {
        List<UserEx> data  = userService.findAllEx();
        return CommonUtil.wrapData(data, CommonUtil.QUERY, true);
    }

    @RequestMapping("testAop2")
    @ResponseBody
    @SystemControllerLog(description = "测试日志2", mainParams = "0")
    public Map<String, Object> testAop2(Long id) throws Exception {
        List<UserEx> data  = userService.findAllEx();
        return CommonUtil.wrapData(data, CommonUtil.QUERY, true);
    }

    @RequestMapping("testAop3")
    @ResponseBody
    @SystemControllerLog(description = "测试日志3")
    public Map<String, Object> testAop3(User user) throws Exception {
        List<UserEx> data  = userService.findAllEx();
        return CommonUtil.wrapData(data, CommonUtil.QUERY, true);
    }

    @RequestMapping("testAop4")
    @ResponseBody
    @SystemControllerLog(description = "测试日志4", mainParams = "0")
    public Map<String, Object> testAop4(User user) throws Exception {
        List<UserEx> data  = userService.findAllEx();
        return CommonUtil.wrapData(data, CommonUtil.QUERY, true);
    }

    @RequestMapping("testAop5")
    @ResponseBody
    @SystemControllerLog(description = "测试日志5", mainParams = "0,1")
    public Map<String, Object> testAop5(User user, Long userId) throws Exception {
        List<UserEx> data  = userService.findAllEx();
        return CommonUtil.wrapData(data, CommonUtil.QUERY, true);
    }

    @RequestMapping("testAop6")
    @ResponseBody
    @SystemControllerLog(description = "测试日志6", mainParams = "0")
    public Map<String, Object> testAop6(String[] ids) throws Exception {
        List<UserEx> data  = userService.findAllEx();
        return CommonUtil.wrapData(data, CommonUtil.QUERY, true);
    }

}
