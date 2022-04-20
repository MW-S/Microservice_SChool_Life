package net.mw.springcloud.controller;

import net.mw.springcloud.pojo.po.VindicatePO;
import net.mw.springcloud.pojo.vo.VindicateVO;
import net.mw.springcloud.service.VindicateService;
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
@RequestMapping("vindicate")
public class VindicateController extends BaseController<VindicateService, VindicatePO, VindicateVO> {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(VindicateController.class);

    @PostMapping(value = "/save")
    public ResultMessage save(@RequestBody VindicateVO vo, @CurrentUser UserPO currentUser){
        return this.save(vo);
    }
}
