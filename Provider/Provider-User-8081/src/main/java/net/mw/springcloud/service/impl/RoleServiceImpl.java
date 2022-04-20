package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.RoleOtherDao;
import net.mw.springcloud.pojo.po.RolePO;
import net.mw.springcloud.pojo.vo.RoleVO;
import net.mw.springcloud.result.ResultMessage;
import net.mw.springcloud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends BaseServiceImpl<RoleOtherDao, RolePO, RoleVO> implements RoleService {
    @Autowired
    RoleService roleDao;
    @Override
    public ResultMessage getList() {
        ResultMessage rs = new ResultMessage();
        try {
            Map<String,Object> data = new HashMap<String,Object>();
//            PageHelper.startPage(page.getPageNumber(), page.getPageSize());
            List<RolePO> pos = roleDao.list();
            List<RoleVO> vos = new ArrayList<>();
            pos.forEach((item)->{
                RoleVO vo = new RoleVO();
                vo.poToVo(item);
                vos.add(vo);
            });
            data.put("size", vos.size());
            data.put("data", vos);
            rs.setData(data);
            rs.setCode(1L);
            rs.setMsg("获取成功!");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            rs.setMsg("参数不正确");
            rs.setCode(2L);
        } catch (Exception e) {
            e.printStackTrace();
            rs.setMsg("获取失败");
            rs.setCode(0L);
        }
        return rs;
    }
}
