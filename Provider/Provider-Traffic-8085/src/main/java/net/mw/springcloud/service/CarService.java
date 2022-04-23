package net.mw.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.mw.springcloud.pojo.po.CarPO;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.result.ResultMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

public interface CarService extends IService<CarPO> {

	public ResultMessage getCode(MultipartFile file);

	public ResultMessage getList(PageRequest page, UserPO user);

	public ResultMessage getByPoId(Long id);

	public ResultMessage savePo(CarPO po);

	public ResultMessage delByIds(String[] ids);

}
