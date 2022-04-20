package net.mw.springcloud.controller;


import net.mw.springcloud.annotation.CurrentUser;
import net.mw.springcloud.pojo.po.SeatOrderPO;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.pojo.vo.SeatOrderVO;
import net.mw.springcloud.result.ResultMessage;
import net.mw.springcloud.service.SeatOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class SeatOrderController extends BaseController<SeatOrderService, SeatOrderPO, SeatOrderVO> {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(SeatOrderController.class);

    public ResultMessage save(@RequestBody SeatOrderVO vo, @CurrentUser UserPO currentUser){
        return this.save(vo);
    }
}
