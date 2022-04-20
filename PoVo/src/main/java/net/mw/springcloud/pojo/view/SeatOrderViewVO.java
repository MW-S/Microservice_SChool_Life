package net.mw.springcloud.pojo.view;

import lombok.Data;
import net.mw.springcloud.pojo.vo.SeatVO;

@Data
public class SeatOrderViewVO extends SeatVO {
    private String useTime;
    private String orderState;
    private String seatId;
}
