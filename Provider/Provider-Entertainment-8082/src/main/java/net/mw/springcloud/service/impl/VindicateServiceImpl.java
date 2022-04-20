package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.VindicateDao;
import net.mw.springcloud.pojo.po.VindicatePO;
import net.mw.springcloud.pojo.vo.VindicateVO;
import net.mw.springcloud.service.VindicateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class VindicateServiceImpl extends BaseServiceImpl<VindicateDao, VindicatePO, VindicateVO> implements VindicateService {

}
