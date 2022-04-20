package net.mw.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.mw.springcloud.pojo.po.DormitoryPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DormitoryDao extends BaseMapper<DormitoryPO> {
    
}
