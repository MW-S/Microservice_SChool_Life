package net.mw.springcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.mw.springcloud.dao.DormitoryUserDao;
import net.mw.springcloud.pojo.po.DormitoryUserPO;
import net.mw.springcloud.pojo.vo.DormitoryUserVO;
import net.mw.springcloud.service.DormitoryUserService;
import net.mw.springcloud.annotation.CurrentUser;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.result.ResultMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dormitoryUser")
public class DormitoryUserController extends BaseController<DormitoryUserService, DormitoryUserPO, DormitoryUserVO> {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(DormitoryUserController.class);

    @Autowired
    DormitoryUserDao dao;

    @PostMapping(value = "/save")
    public ResultMessage save(@RequestBody DormitoryUserVO vo, @CurrentUser UserPO currentUser){
        QueryWrapper<DormitoryUserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", vo.getUserId());
        if(dao.selectCount(queryWrapper) > 0){
            vo.setId(dao.selectOne(queryWrapper).getId().toString());
        }
        return this.save(vo);
    }
}
