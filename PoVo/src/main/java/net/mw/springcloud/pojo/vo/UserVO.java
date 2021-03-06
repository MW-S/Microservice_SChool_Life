/**
 * @Description UserVO
 * @Author W_Messi
 * @CrateTime 2020-04-17 18:57:54
 * 
 */
package net.mw.springcloud.pojo.vo;

import lombok.Data;
import net.mw.springcloud.pojo.base.BaseVO;

/**
 * @Description UserVO接口实现
 * @Author W_Messi
 * @CrateTime 2020-04-17 18:57:54
 */
@Data
public class UserVO extends BaseVO {
	/**
	 * 用户主键
	 */
	private String id;

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
	private String userName;
	
	/**
	 * 性别
	 * 
	 */
	private String gender;

	/**
	 * 类型
	 * 
	 */
	private String type;

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
	private String state;

	/**
	 * 车辆ID
	 *
	 */
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
	private String gmtCreate;
	/**
	 *修改时间
	 */
	private String gmtUpdate;
	/**
	 *是否删除
	 */
	private String isDeleted;
	/**
	 *是否冻结
	 */
	private String isLocked;
}
