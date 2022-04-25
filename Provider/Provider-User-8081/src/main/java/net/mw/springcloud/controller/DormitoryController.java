package net.mw.springcloud.controller;

import net.mw.springcloud.annotation.CurrentUser;
import net.mw.springcloud.pojo.po.DormitoryPO;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.pojo.vo.DormitoryVO;
import net.mw.springcloud.result.ResultMessage;
import net.mw.springcloud.service.DormitoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dormitory")
public class DormitoryController extends BaseController<DormitoryService, DormitoryPO, DormitoryVO> {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(DormitoryController.class);

    @PostMapping(value = "/save")
    public ResultMessage save(@RequestBody DormitoryVO vo, @CurrentUser UserPO currentUser){

        return this.save(vo);
    }
}
