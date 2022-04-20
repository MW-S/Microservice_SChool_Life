package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.FoodDao;
import net.mw.springcloud.pojo.po.FoodPO;
import net.mw.springcloud.pojo.vo.FoodVO;
import net.mw.springcloud.service.FoodService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class FoodServiceImpl extends BaseServiceImpl<FoodDao, FoodPO, FoodVO> implements FoodService {

}
