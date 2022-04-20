package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.SeatOrderDao;
import net.mw.springcloud.pojo.po.SeatOrderPO;
import net.mw.springcloud.pojo.vo.SeatOrderVO;
import net.mw.springcloud.service.SeatOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class SeatOrderServiceImpl extends BaseServiceImpl<SeatOrderDao, SeatOrderPO, SeatOrderVO> implements SeatOrderService {

}
