package net.mw.springcloud.dao;

import net.mw.springcloud.pojo.po.UserPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    @Select("select *,account AS user_name,create_gtm as gmt_create from user")
    public List<UserPO>  getUserList();
    
    @Select("select count(*) from user")
    public String getUserListSize();

    @Select("select *,account AS user_name,create_gtm as gmt_create from user where id = #{id}")
    public UserPO getUserById(Long id);

    @Select("select id from user order by id DESC LIMIT 1")
    public Long getLastId();
    
    @Select("select *,account AS user_name,create_gtm as gmt_create from user where account = #{userName}")
    public List<UserPO> getUsersByAccount(UserPO po);
    
    @Select("select *,account AS user_name,create_gtm as gmt_create from user where account = #{userName}")
    public UserPO getUserByAccount(String userName);

    @Select("select *,account AS user_name,create_gtm as gmt_create from user where account = #{userName}")
    public List<UserPO> getUserListByAccount(String userName);
    
    @Insert("insert into user(account, name, type, password, gender, phone,  session_key, salt) " +
            "value(#{userName}, #{name}, #{type}, #{password}, #{gender}, #{phone}, #{sessionKey}, #{salt})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
    public Integer save(UserPO po);
    
    @Insert("update user set name = #{name}, type = #{type} , gender = #{gender}, phone = #{phone}, state = #{state} " +
            " where id = #{id}")
    public Integer update(UserPO po);

    @Insert("update user set carId = #{carId} where id = #{id}")
    public Integer updateCarId(UserPO po);

    @Insert("update user set password = #{password} , salt = #{salt}" +
            " where id = #{id}")
    public Integer resetPwd(UserPO po);
    
    @Delete("delete from user where  id = #{id}")
    public Integer del(UserPO po);
    

}
