package net.mw.springcloud.controller;

import net.mw.springcloud.annotation.CurrentUser;
import net.mw.springcloud.pojo.po.CanteenPO;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.pojo.vo.CanteenVO;
import net.mw.springcloud.pojo.vo.DeliveryOrderVO;
import net.mw.springcloud.result.ResultMessage;
import net.mw.springcloud.service.CanteenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;


/**
 * @Description TaskController接口实现
 * @Author W_Messi
 * @CrateTime 2021-03-06 23:51:25
 */
@RestController
@RequestMapping("canteen")
public class CanteenController extends BaseController< CanteenService,  CanteenPO,  CanteenVO>{
	/**
	 * log4j实例对象.
	 */
	private static Logger logger = LogManager.getLogger(CanteenController.class);

	@PostMapping(value = "/save")
	public ResultMessage save(@RequestBody CanteenVO vo, @CurrentUser UserPO currentUser){
		return this.save(vo);
	}

}
