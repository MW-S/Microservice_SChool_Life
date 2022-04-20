package net.mw.springcloud.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.result.ResultMessage;
import org.springframework.data.domain.PageRequest;

public interface BaseService <T> extends IService<T> {


    public ResultMessage getList(PageRequest page, UserPO user);

    public ResultMessage getList(PageRequest page, QueryWrapper<T> queryWrapper, UserPO user);

    public ResultMessage getByPoId(Long id);

    public ResultMessage savePo(T po);

    public ResultMessage delByIds(String[] ids);
}
