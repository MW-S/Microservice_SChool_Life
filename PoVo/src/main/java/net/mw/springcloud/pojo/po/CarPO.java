package net.mw.springcloud.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.mw.springcloud.pojo.base.BasePO;

/**
 * @author W_Messi
 * @Description 车辆实体
 * @CreateTime 2022/3/27 22:23
 */
@Data
@TableName("car")
public class CarPO extends BasePO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 车牌号
     */
    private String number;

    /**
     * 用户ID
     */
    /*    private Long userId;*/

}
