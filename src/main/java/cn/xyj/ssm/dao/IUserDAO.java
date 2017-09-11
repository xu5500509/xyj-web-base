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

package cn.xyj.ssm.dao;

import cn.xyj.ssm.base.IBaseDAO;
import cn.xyj.ssm.domain.User;
import cn.xyj.ssm.domain.UserEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《【用户】》 数据访问接口
 * @author xyj
 *
 */
public interface IUserDAO extends IBaseDAO<User> {


     List<UserEx> findAllEx(@Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    List<User> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows,
                           @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    int countEx(@Param("condition") Map<String, Object> condition);
}