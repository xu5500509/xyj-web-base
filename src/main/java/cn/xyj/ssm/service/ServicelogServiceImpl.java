/*
{*****************************************************************************
{  电影系统 v1.0													
{  创建人：  xyj
{  审查人：
{  模块：											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2018-01-09  xyj        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************
*/

package cn.xyj.ssm.service;

import cn.xyj.ssm.dao.IServicelogDAO;
import cn.xyj.ssm.domain.Servicelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《日志表》 业务逻辑服务类
 * @author xyj
 *
 */
@Service("ServicelogServiceImpl")
public class ServicelogServiceImpl implements IServicelogService{
    @Autowired
    private IServicelogDAO servicelogDAO;


     @Override
     public void add(Servicelog log) {
         servicelogDAO.insert(log);
     }
 }