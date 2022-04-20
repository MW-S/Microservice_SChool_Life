package net.mw.springcloud.controller;


import net.mw.springcloud.annotation.CurrentUser;
import net.mw.springcloud.pojo.po.ParkingOrderPO;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.pojo.vo.ParkingOrderVO;
import net.mw.springcloud.result.ResultMessage;
import net.mw.springcloud.service.ParkingOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ParkingOrderController extends BaseController<ParkingOrderService, ParkingOrderPO, ParkingOrderVO> {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(ParkingOrderController.class);

    public ResultMessage save(@RequestBody ParkingOrderVO vo, @CurrentUser UserPO currentUser){
        return this.save(vo);
    }
}
