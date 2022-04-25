package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.DormitoryUserDao;
import net.mw.springcloud.pojo.po.DormitoryUserPO;
import net.mw.springcloud.pojo.vo.DormitoryUserVO;
import net.mw.springcloud.service.DormitoryUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class DormitoryUserServiceImpl extends BaseServiceImpl<DormitoryUserDao, DormitoryUserPO, DormitoryUserVO> implements DormitoryUserService {

}
