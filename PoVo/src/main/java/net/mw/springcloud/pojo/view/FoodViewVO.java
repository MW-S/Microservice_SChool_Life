package net.mw.springcloud.pojo.view;

import lombok.Data;
import net.mw.springcloud.pojo.vo.FoodVO;


@Data
public class FoodViewVO extends FoodVO {
    private String canteen;
}
