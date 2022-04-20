package net.mw.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import net.mw.springcloud.dao.NoteDao;
import net.mw.springcloud.pojo.po.NotePO;
import net.mw.springcloud.pojo.vo.NoteVO;
import net.mw.springcloud.service.NoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class NoteServiceImpl extends BaseServiceImpl<NoteDao, NotePO, NoteVO> implements NoteService {

}
