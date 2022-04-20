package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.DeliveryOrderDao;
import net.mw.springcloud.pojo.po.DeliveryOrderPO;
import net.mw.springcloud.pojo.vo.DeliveryOrderVO;
import net.mw.springcloud.service.DeliveryOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class DeliveryOrderServiceImpl extends BaseServiceImpl<DeliveryOrderDao, DeliveryOrderPO, DeliveryOrderVO> implements DeliveryOrderService {

}
