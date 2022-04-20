package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.SeatDao;
import net.mw.springcloud.pojo.po.SeatPO;
import net.mw.springcloud.pojo.vo.SeatVO;
import net.mw.springcloud.service.SeatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class SeatServiceImpl extends BaseServiceImpl<SeatDao, SeatPO, SeatVO> implements SeatService {

}
