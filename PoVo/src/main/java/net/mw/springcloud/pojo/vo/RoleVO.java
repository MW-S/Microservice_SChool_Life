/**
 * 
 */
package net.mw.springcloud.pojo.vo;


import lombok.Data;
import net.mw.springcloud.pojo.base.BaseVO;

/**
 * @Description
 * @author W_Messi
 * @CrateTime 2020/3/2 12:22
 */
@Data
public class RoleVO extends BaseVO {
	/**
	 * 主键
	 * 
	 */
	private String id;

	/**
	 * 角色名
	 * 
	 */
	private String name;

}
