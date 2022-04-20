package net.mw.springcloud.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.mw.springcloud.pojo.base.BasePO;

/**
 * @author W_Messi
 * @Description 宿舍实体
 * @CreateTime 2022/3/27 22:23
 */
@Data
@TableName("dormitory")
public class DormitoryPO extends BasePO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 宿舍名
     */
    private String name;

    /**
     * 宿舍所属栋
     */
    private String location;


}
