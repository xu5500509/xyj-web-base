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

package cn.xyj.ssm.domain;

import cn.xyj.ssm.base.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《【用户】》 实体
 * @author xyj
 *
 */
public class User extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String name; //用户姓名
	private String password; //密码
	private String image; //头像
	private String email; //邮箱（登录名）
	private Integer role; //1系统管理员，2普通用户
	private String code; //预留字段，（验证code）
    
	/**
	 *默认空构造函数
	 */
	public User() {
		super();
	}
	 
	/**
	 * @return name 用户姓名
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 用户姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return password 密码
	 */
	public String getPassword(){
		return this.password;
	}
	/**
	 * @param password 密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 * @return image 头像
	 */
	public String getImage(){
		return this.image;
	}
	/**
	 * @param image 头像
	 */
	public void setImage(String image){
		this.image = image;
	}
	/**
	 * @return email 邮箱（登录名）
	 */
	public String getEmail(){
		return this.email;
	}
	/**
	 * @param email 邮箱（登录名）
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 * @return role 1系统管理员，2普通用户
	 */
	public Integer getRole(){
		return this.role;
	}
	/**
	 * @param role 1系统管理员，2普通用户
	 */
	public void setRole(Integer role){
		this.role = role;
	}
	/**
	 * @return code 预留字段，（验证code）
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 预留字段，（验证code）
	 */
	public void setCode(String code){
		this.code = code;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("name",getName())
			.append("password",getPassword())
			.append("image",getImage())
			.append("email",getEmail())
			.append("role",getRole())
			.append("code",getCode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getName())
			.append(getPassword())
			.append(getImage())
			.append(getEmail())
			.append(getRole())
			.append(getCode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
