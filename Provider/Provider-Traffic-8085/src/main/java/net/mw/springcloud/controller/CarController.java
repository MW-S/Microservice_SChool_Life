package net.mw.springcloud.controller;

import net.mw.springcloud.pojo.po.CarPO;
import net.mw.springcloud.pojo.vo.CarVO;
import net.mw.springcloud.service.CarService;
import net.mw.springcloud.annotation.CurrentUser;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.result.ResultMessage;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Description TaskController接口实现
 * @Author W_Messi
 * @CrateTime 2021-03-06 23:51:25
 */
@RestController
@RequestMapping("car")
public class CarController {
	/**
	 * log4j实例对象.
	 */
	private static Logger logger = LogManager.getLogger(CarController.class);
	

    @Autowired
    private CarService service;

    @GetMapping(value = "/getList")
	public ResultMessage getList(@RequestParam(value="page", required=false) Integer page,
								 @RequestParam(value="size",required=false) Integer size
			, @CurrentUser UserPO user){
		logger.trace("进入getList方法");
		PageRequest pageVo = null;
		if(ObjectUtils.allNotNull(page,size)){
			pageVo =  PageRequest.of(page, size);
		}
		ResultMessage rs=service.getList(pageVo, user);
		logger.trace("退出getList方法");
		return rs;
	}
    
    @GetMapping(value = "/getById")
    public ResultMessage getById(@RequestParam("id") String id){
		logger.trace("进入getById方法");
		ResultMessage rs=service.getByPoId(Long.valueOf(id));
		logger.trace("退出getById方法");
		return rs;
    }

    
    @PostMapping(value = "/save")
    public ResultMessage save(@RequestBody CarVO vo){
		logger.trace("进入 save 方法");
		CarPO po = vo.voToPo(CarPO.class);
		ResultMessage rs=service.savePo(po);
		logger.trace("退出 save 方法");
		return rs;
    }

    
    @PostMapping(value = "/delByIds")
    public ResultMessage delByIds(@RequestParam("ids") String[] ids){
		logger.trace("进入 delByIds 方法");
		ResultMessage rs=service.delByIds(ids);
		logger.trace("退出 delByIds 方法");
		return rs;
    }

	@PostMapping(value = "/recognize", produces = {"application/json;charset=UTF-8"})
	public ResultMessage recognize(@RequestParam("image") MultipartFile image){
		logger.trace("进入recognize方法");
		ResultMessage rs=service.getCode(image);
		logger.trace("退出recognize方法");
		return rs;
	}
}
