package net.mw.springcloud.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.mw.springcloud.pojo.base.BasePO;

/**
 * @author W_Messi
 * @Description 图书馆座位实体
 * @CreateTime 2022/3/27 22:23
 */
@Data
@TableName("seat")
public class SeatPO extends BasePO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 座位号
     */
    private String code;

    /**
     * 所在教室
     */
    private String location;

    /**
     * 所在校区
     */
    private Integer school;

    /**
     * 座位状态 1-已占用  0-空闲
     */
    private Boolean state;


}
