/*
{*****************************************************************************
{  电影系统 v1.0													
{  创建人：  xyj
{  审查人：
{  模块：【用户】											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-03-02  xyj        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************
*/

package cn.xyj.ssm.service;


import cn.xyj.ssm.domain.Enum.SqlOrderEnum;
import cn.xyj.ssm.domain.User;
import cn.xyj.ssm.domain.UserEx;
import cn.xyj.ssm.utils.BizData4Page;

import java.util.List;

/**
 * 《【用户】》 业务逻辑服务接口
 * @author xyj
 *
 */
public interface IUserService {

    List<UserEx> findAllEx();

    int testTra() throws Exception;
}