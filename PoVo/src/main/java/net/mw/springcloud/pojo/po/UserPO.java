/**
 * 
 */
package net.mw.springcloud.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 用户实体
 * @author W_Messi
 * @CreateTime 2020/3/2 12:02
 *
 */
@Data
@TableName("user")
public class UserPO implements Serializable  {

	/**
	 * 用户主键
	 */
	private Long id;

	/**
	 * 头像
	 * 
	 */
	private String avatarUrl;
	/**
	 * 昵称
	 *
	 */
	private String name;
	/**
	 * 用户名
	 * 
	 */
	@TableField("account")
	private String userName;
	
	/**
	 * 性别
	 * 
	 */
	private Integer gender;

	/**
	 * 类型
	 * 
	 */
	private Integer type;

	/**
	 * 密码
	 * 
	 */
	private String password;

	/**
	 * 手机号码
	 * 
	 */
	private String phone;
	
	/**
	 *会话密钥
	 * 
	 */
	private String sessionKey;
	/**
	 * 盐值
	 * 
	 */
	private String salt;

	/**
	 * 状态 0是正常 1是禁用
	 */
	private Integer state;

	/**
	 * 车辆ID
	 *
	 */
	@TableField("car_id")
	private String carId;

	/**
	 * 车辆图片
	 *
	 */
	private String carPicture;

	/**
	 * 学号
	 *
	 */
	private String number;

	/**
	 *创建时间
	 */
	@TableField("create_gtm")
	private Date gmtCreate;
	/**
	 *修改时间
	 */
	@TableField("update_gtm")
	private Date gmtUpdate;
	/**
	 *是否删除
	 */
	private String isDeleted;
	/**
	 *是否冻结
	 */
	private String isLocked;

}
