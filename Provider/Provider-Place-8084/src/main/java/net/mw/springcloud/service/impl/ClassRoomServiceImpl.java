package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.ClassRoomDao;
import net.mw.springcloud.pojo.po.ClassRoomPO;
import net.mw.springcloud.pojo.vo.ClassRoomVO;
import net.mw.springcloud.service.ClassRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class ClassRoomServiceImpl extends BaseServiceImpl<ClassRoomDao, ClassRoomPO, ClassRoomVO> implements ClassRoomService {

}
