package cn.xyj.ssm.controller;

import cn.xyj.ssm.domain.Enum.SqlOrderEnum;
import cn.xyj.ssm.domain.User;
import cn.xyj.ssm.domain.UserEx;
import cn.xyj.ssm.param.UserParam;
import cn.xyj.ssm.service.IUserService;
import cn.xyj.ssm.utils.BizData4Page;
import cn.xyj.ssm.utils.CommonUtil;
import cn.xyj.ssm.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * 后台用户controller
 */
@Controller
@RequestMapping({"/user"})
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("findAll")
    @ResponseBody
    public Map<String, Object> findAll() throws Exception {
        boolean isSuc = false;
        List<UserEx> data  =  new ArrayList<>();
        try {
            data = userService.findAllEx();
            isSuc = true;
            //int a = 1/0;
        } catch (Exception e) {
            throw new Exception(e);
        }
        return CommonUtil.wrapData(data, CommonUtil.QUERY, isSuc);
    }



    /**
     * 测试事务
     * @Author: xuyangjian
     * @Date: 2017/10/16 22:47
     */
    @RequestMapping("testTra")
    @ResponseBody
    public Map<String, Object> testTra() throws Exception {
        boolean isSuc = false;
        try {
            int num = userService.testTra();
            if (num > 0)
            isSuc = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return CommonUtil.wrapData(CommonUtil.ADD, isSuc);
    }
}
