package net.mw.springcloud.controller;

import net.mw.springcloud.dao.ClassRoomDao;
import net.mw.springcloud.dao.SeatDao;
import net.mw.springcloud.dao.SeatOrderDao;
import net.mw.springcloud.pojo.po.ClassRoomPO;
import net.mw.springcloud.pojo.po.SeatPO;
import net.mw.springcloud.pojo.vo.ClassRoomVO;
import net.mw.springcloud.pojo.vo.SeatOrderVO;
import net.mw.springcloud.pojo.vo.SeatVO;
import net.mw.springcloud.service.ClassRoomService;
import net.mw.springcloud.service.SeatService;
import net.mw.springcloud.annotation.CurrentUser;
import net.mw.springcloud.controller.BaseController;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.result.ResultMessage;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("classRoom")
public class ClassRoomController extends BaseController<ClassRoomService, ClassRoomPO, ClassRoomVO> {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(ClassRoomController.class);

    @PostMapping(value = "/save")
    public ResultMessage save(@RequestBody ClassRoomVO vo, @CurrentUser UserPO currentUser){
        return this.save(vo);
    }
}
