package net.mw.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.mw.springcloud.pojo.po.NotePO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NoteDao extends BaseMapper<NotePO> {
    
}
