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

package cn.xyj.ssm.domain;

import cn.xyj.ssm.base.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;

/**
 * 《日志表》 实体
 * @author xyj
 *
 */
public class Servicelog extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String logDescription; //
	private String logParams; //
	private Date logTime; //
	private String logMethod; //
	private Integer logType; //
	private String logIp; //
    
	/**
	 *默认空构造函数
	 */
	public Servicelog() {
		super();
	}
	 
	/**
	 * @return logDescription 
	 */
	public String getLogDescription(){
		return this.logDescription;
	}
	/**
	 * @param logDescription 
	 */
	public void setLogDescription(String logDescription){
		this.logDescription = logDescription;
	}
	/**
	 * @return logParams 
	 */
	public String getLogParams(){
		return this.logParams;
	}
	/**
	 * @param logParams 
	 */
	public void setLogParams(String logParams){
		this.logParams = logParams;
	}
	/**
	 * @return logTime 
	 */
	public Date getLogTime(){
		return this.logTime;
	}
	/**
	 * @param logTime 
	 */
	public void setLogTime(Date logTime){
		this.logTime = logTime;
	}
	/**
	 * @return logMethod 
	 */
	public String getLogMethod(){
		return this.logMethod;
	}
	/**
	 * @param logMethod 
	 */
	public void setLogMethod(String logMethod){
		this.logMethod = logMethod;
	}
	/**
	 * @return logType 
	 */
	public Integer getLogType(){
		return this.logType;
	}
	/**
	 * @param logType 
	 */
	public void setLogType(Integer logType){
		this.logType = logType;
	}
	/**
	 * @return logIp 
	 */
	public String getLogIp(){
		return this.logIp;
	}
	/**
	 * @param logIp 
	 */
	public void setLogIp(String logIp){
		this.logIp = logIp;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("logDescription",getLogDescription())
			.append("logParams",getLogParams())
			.append("logTime",getLogTime())
			.append("logMethod",getLogMethod())
			.append("logType",getLogType())
			.append("logIp",getLogIp())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getLogDescription())
			.append(getLogParams())
			.append(getLogTime())
			.append(getLogMethod())
			.append(getLogType())
			.append(getLogIp())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Servicelog == false) return false;
		if(this == obj) return true;
		Servicelog other = (Servicelog)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}
