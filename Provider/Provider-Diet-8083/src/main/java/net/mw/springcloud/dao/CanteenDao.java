package net.mw.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.mw.springcloud.pojo.po.CanteenPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CanteenDao extends BaseMapper<CanteenPO> {

    @Select("select * from canteen ")
    public List<CanteenPO>  getList();

    @Select("select * from canteen where id = #{id}")
    public CanteenPO getById(Long id);
}
