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

package cn.xyj.ssm.param;

import cn.xyj.ssm.base.BaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《【用户】》 查询参数实体
 * @author xyj
 *
 */
public class UserParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——用户姓名
	*/
	public static final String F_Name="name";
	/**
	*字段常量——密码
	*/
	public static final String F_Password="password";
	/**
	*字段常量——头像
	*/
	public static final String F_Image="image";
	/**
	*字段常量——邮箱（登录名）
	*/
	public static final String F_Email="email";
	/**
	*字段常量——1系统管理员，2普通用户
	*/
	public static final String F_Role="role";
	/**
	*字段常量——预留字段，（验证code）
	*/
	public static final String F_Code="code";
	
	private String name; //用户姓名
	private String password; //密码
	private String image; //头像
	private String email; //邮箱（登录名）
	private Integer role; //1系统管理员，2普通用户
	private String code; //预留字段，（验证code）
    
	/**
	 *默认空构造函数
	 */
	public UserParam() {
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
	
}
