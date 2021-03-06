package net.mw.springcloud.service;

import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.result.ResultMessage;
import org.springframework.data.domain.PageRequest;



/**
 * @Description UserService接口实现
 * @Author W_Messi
 * @CrateTime 2021-03-03 16:21:52
 */
public interface UserService {


    /**
    *
    * 2020年4月17日
    * @Param user 用户信息
    * @Param code 信息标识码
    * Map<String,Object>
    */
   public ResultMessage getList(PageRequest page, Integer type);
	
    /**
     *
     * 2020年4月17日
     * @Param user 用户信息
     * @Param code 信息标识码
     * Map<String,Object>
     */
    public ResultMessage login(UserPO user);

    /**
     *
     * 2020年4月17日
     * @Param user 用户信息
     * @Param code 信息标识码
     * Map<String,Object>
     */
    public ResultMessage wxLogin(UserPO user);
    /**
     *
     * 2020年4月17日
     * @Param user 用户信息
     * Map<String,Object>
     */
    public ResultMessage register(UserPO user);
    
    
    /**
    *
    * 2020年4月17日
    * @Param user 用户信息
    * @Param code 信息标识码
    * Map<String,Object>
    */
   public ResultMessage logout();
   
 
	public ResultMessage getById(Long id);
	
	public ResultMessage update(UserPO po);

    public ResultMessage updateCarId(UserPO po);
	
	public ResultMessage del(UserPO po);
   
	
	public ResultMessage resetPwd(UserPO po);
   
   

}
