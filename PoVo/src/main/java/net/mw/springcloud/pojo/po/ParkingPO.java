package net.mw.springcloud.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.mw.springcloud.pojo.base.BasePO;

/**
 * @author W_Messi
 * @Description 停车位实体
 * @CreateTime 2022/3/27 22:23
 */
@Data
@TableName("parking")
public class ParkingPO extends BasePO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 车位号
     */
    private String code;

    /**
     * 车位状态  1-已占用  0-空闲
     */
    private Boolean state;

}
