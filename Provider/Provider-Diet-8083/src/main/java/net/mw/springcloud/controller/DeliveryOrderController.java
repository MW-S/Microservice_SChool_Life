package net.mw.springcloud.controller;

import net.mw.springcloud.pojo.po.DeliveryOrderPO;
import net.mw.springcloud.pojo.vo.DeliveryOrderVO;
import net.mw.springcloud.service.DeliveryOrderService;
import net.mw.springcloud.annotation.CurrentUser;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.result.ResultMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("deliveryOrder")
public class DeliveryOrderController extends BaseController<DeliveryOrderService, DeliveryOrderPO, DeliveryOrderVO> {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(DeliveryOrderController.class);

    @PostMapping(value = "/save")
    public ResultMessage save(@RequestBody DeliveryOrderVO vo, @CurrentUser UserPO currentUser){
        vo.setUserId(String.valueOf(currentUser.getId()));
        return this.save(vo);
    }
}
