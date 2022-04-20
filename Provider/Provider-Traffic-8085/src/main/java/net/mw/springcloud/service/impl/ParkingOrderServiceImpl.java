package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.ParkingOrderDao;
import net.mw.springcloud.pojo.po.ParkingOrderPO;
import net.mw.springcloud.pojo.vo.ParkingOrderVO;
import net.mw.springcloud.service.ParkingOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class ParkingOrderServiceImpl extends BaseServiceImpl<ParkingOrderDao, ParkingOrderPO, ParkingOrderVO> implements ParkingOrderService {

}
