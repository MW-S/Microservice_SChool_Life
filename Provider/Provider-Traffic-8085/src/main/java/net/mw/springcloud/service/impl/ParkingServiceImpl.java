package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.ParkingDao;
import net.mw.springcloud.pojo.po.ParkingPO;
import net.mw.springcloud.pojo.vo.ParkingVO;
import net.mw.springcloud.service.ParkingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class ParkingServiceImpl extends BaseServiceImpl<ParkingDao, ParkingPO, ParkingVO> implements ParkingService {

}
