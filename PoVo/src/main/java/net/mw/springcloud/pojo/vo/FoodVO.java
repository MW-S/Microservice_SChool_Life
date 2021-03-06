/**
 * 
 */
package net.mw.springcloud.pojo.vo;

import lombok.Data;
import net.mw.springcloud.pojo.base.BaseVO;

/**
 * @Description 食物实体
 * @author W_Messi
 * @CreateTime 2022/3/27 22:38
 *
 */
@Data
public class FoodVO extends BaseVO {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 食物名
	 *
	 */
	private String name;

	/**
	 * 食物类型
	 *
	 */
	private String type;

	/**
	 * 食物价格
	 *
	 */
	private String price;

	/**
	 * 食物图片
	 * 
	 */
	private String pictures;

	/**
	 * 饭堂ID
	 */
	private String canteenId;

	/**
	 *提供日期
	 */
	private String offerDate;

}
