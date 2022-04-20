/**
 * 
 */
package net.mw.springcloud.pojo.po;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.mw.springcloud.pojo.base.BasePO;

/**
 * @Description
 * @author W_Messi
 * @CrateTime 2020/3/2 12:22
 */
@Data
@TableName("role")
public class RolePO extends BasePO {
	/**
	 * 主键
	 * 
	 */
	private Long id;

	/**
	 * 角色名
	 * 
	 */
	private String name;

}
