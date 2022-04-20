package net.mw.springcloud.controller;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.pojo.vo.UserVO;
import net.mw.springcloud.result.ResultMessage;
import net.mw.springcloud.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("user")
public class UserController {
	
	/**
	 * log4j实例对象.
	 */
	private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @GetMapping(value = "/getList")
    public ResultMessage getList(@RequestParam(value = "page", required = false) Integer page,
								 @RequestParam(value = "size", required = false) Integer size){
		logger.trace("进入getList方法");
		PageRequest pageVo = null;
		if(ObjectUtils.allNotNull(page,size)){
			pageVo = PageRequest.of(page, size);
		}
		ResultMessage rs=service.getList(pageVo);
		logger.trace("退出getList方法");
		return rs;
    }
    
    
    
    @PostMapping(value = "/add")
    public ResultMessage register(@RequestBody UserVO vo){
		logger.trace("进入register方法");
		UserPO po = vo.voToPo(UserPO.class);
		ResultMessage rs=service.register(po);
		logger.trace("退出register方法");
		return rs;
    }
    
    @PostMapping(value = "/update")
    public ResultMessage update(@RequestBody UserVO vo){
		logger.trace("进入add方法");
		UserPO po = vo.voToPo(UserPO.class);
		ResultMessage rs=service.update(po);
		logger.trace("退出add方法");
		return rs;
    }

	@PostMapping(value = "/updateCarId")
	public ResultMessage updateCarId(@RequestBody UserVO vo){
		logger.trace("进入 updateCarId 方法");
		UserPO po = vo.voToPo(UserPO.class);
		ResultMessage rs=service.updateCarId(po);
		logger.trace("退出 updateCarId 方法");
		return rs;
	}
    
    @PostMapping(value = "/del")
    public ResultMessage del(@RequestBody UserVO vo){
		logger.trace("进入add方法");
		UserPO po = vo.voToPo(UserPO.class);
		ResultMessage rs=service.del(po);
		logger.trace("退出add方法");
		return rs;
    }
}
