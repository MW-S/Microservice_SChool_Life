package net.mw.springcloud.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.mw.springcloud.pojo.po.UserPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao extends BaseMapper<UserPO> {
    @Select("select *,account AS user_name,create_gtm as gmt_create from user")
    public List<UserPO>  getUserList();

    @Select("select *,account AS user_name,create_gtm as gmt_create from user where type = #{type}")
    public List<UserPO>  getUserListByType(Integer type);

    @Select("select count(*) from user")
    public String getUserListSize();

    @Select("select count(*) from user where type = #{type}")
    public String getUserListSizByTye(Integer type);

    @Select("select *,account AS user_name,create_gtm as gmt_create from user where id = #{id}")
    public UserPO getUserById(Long id);

    @Select("select id from user order by id DESC LIMIT 1")
    public Long getLastId();
    
    @Select("select *,account AS user_name,create_gtm as gmt_create from user where account = #{userName}")
    public List<UserPO> getUsersByAccount(UserPO po);
    
    @Select("select *,account AS user_name,create_gtm as gmt_create from user where account = #{userName}")
    public UserPO getUserByAccount(String userName);

    @Select("select count(*) from user where account = #{userName}")
    public Integer getUserCountByAccount(String userName);

    @Select("select *,account AS user_name,create_gtm as gmt_create from user where account = #{userName}")
    public List<UserPO> getUserListByAccount(String userName);

    @Insert("insert into user(account, name, type, password, gender, phone,  session_key, salt, " +
            "avatar_url, car_id, car_picture) " +
            "value(#{userName}, #{name}, #{type}, #{password}, #{gender}, #{phone}, #{sessionKey}, #{salt}," +
            " #{avatarUrl}, #{carId}, #{carPicture})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
    public Integer save(UserPO po);

    @Insert("update user set car_id = #{carId} , car_picture = #{carPicture} where id = #{id}")
    public Integer updateUserCar(UserPO po);

    @Insert("update user set password = #{password} , salt = #{salt}" +
            " where id = #{id}")
    public Integer resetPwd(UserPO po);
    
    @Delete("delete from user where  id = #{id}")
    public Integer del(UserPO po);
    

}
