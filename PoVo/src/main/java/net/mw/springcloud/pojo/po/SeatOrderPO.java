package net.mw.springcloud.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.mw.springcloud.pojo.base.BasePO;

/**
 * @author W_Messi
 * @Description 图书馆座位预约实体
 * @CreateTime 2022/3/27 22:23
 */
@Data
@TableName("seat_order")
public class SeatOrderPO extends BasePO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 使用人ID
     */
    private Long userId;

    /**
     * 座位ID
     */
    private Long seatId;

    /**
     * 使用时长
     */
    private String useTime;

    /**
     * 订单状态
     */
    private Integer state;


}
