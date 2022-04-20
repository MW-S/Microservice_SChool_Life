package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.DormitoryDao;
import net.mw.springcloud.pojo.po.DormitoryPO;
import net.mw.springcloud.pojo.vo.DormitoryVO;
import net.mw.springcloud.service.DormitoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class DormitoryServiceImpl extends BaseServiceImpl<DormitoryDao, DormitoryPO, DormitoryVO> implements DormitoryService {

}
