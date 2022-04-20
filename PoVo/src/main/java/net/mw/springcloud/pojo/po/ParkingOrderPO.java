package net.mw.springcloud.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.mw.springcloud.pojo.base.BasePO;

/**
 * @author W_Messi
 * @Description 停车订单实体
 * @CreateTime 2022/3/27 22:23
 */
@Data
@TableName("parking_order")
public class ParkingOrderPO extends BasePO {

    /**
     * 主键
     */
    private Long id;


    /**
     * 车位ID
     */
    private Long parkingId;


    /**
     * 车辆ID
     */
    private Long carId;

}
