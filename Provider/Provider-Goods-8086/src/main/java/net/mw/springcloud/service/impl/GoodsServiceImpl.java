package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.GoodsDao;
import net.mw.springcloud.pojo.po.GoodsPO;
import net.mw.springcloud.pojo.vo.GoodsVO;
import net.mw.springcloud.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl extends BaseServiceImpl<GoodsDao, GoodsPO, GoodsVO> implements GoodsService {

}
