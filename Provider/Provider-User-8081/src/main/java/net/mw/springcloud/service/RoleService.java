package net.mw.springcloud.service;


import net.mw.springcloud.pojo.po.RolePO;
import net.mw.springcloud.result.ResultMessage;

public interface RoleService extends BaseService<RolePO> {
    public ResultMessage getList();
}
