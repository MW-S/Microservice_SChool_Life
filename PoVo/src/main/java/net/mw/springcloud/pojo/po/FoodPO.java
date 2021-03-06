/**
 *
 */
package net.mw.springcloud.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.mw.springcloud.pojo.base.BasePO;

import java.sql.Date;


/**
 * @Description 食物实体
 * @author W_Messi
 * @CreateTime 2022/3/27 22:38
 *
 */
@Data
@TableName("food")
public class FoodPO extends BasePO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 食物名
     *
     */
    private String name;

    /**
     * 食物类型
     *
     */
    private Integer type;

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
    private Long canteenId;

    /**
     *提供日期
     */
    private Date offerDate;

}
