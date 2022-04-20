package net.mw.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.mw.springcloud.pojo.po.CanteenPO;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.result.ResultMessage;
import org.springframework.data.domain.PageRequest;


public interface CanteenService extends IService<CanteenPO> {

	public ResultMessage getList(PageRequest page, UserPO user);

	public ResultMessage getByPoId(Long id);

	public ResultMessage savePo(CanteenPO po);

	public ResultMessage delByIds(String[] ids);

}
