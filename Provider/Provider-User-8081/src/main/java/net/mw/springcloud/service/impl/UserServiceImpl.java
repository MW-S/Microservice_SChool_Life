package net.mw.springcloud.service.impl;

import java.util.*;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.mw.springcloud.constant.UserRoleConstants;
import net.mw.springcloud.dao.*;
import net.mw.springcloud.pojo.po.*;
import net.mw.springcloud.pojo.vo.UserVO;
import net.mw.springcloud.result.ResultMessage;
import net.mw.springcloud.service.UserService;
import net.mw.springcloud.utils.Encrypt;
import net.mw.springcloud.utils.JwtTokenUtils;
import net.mw.springcloud.utils.MinioHelper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;


@Service
public class UserServiceImpl implements UserService {

	/**
	 * log4j实例对象.
	 */
	private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private MinioHelper minio;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
	@Autowired
	private UserDao dao;
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private NoteDao noteDao;

	@Autowired
	private VindicateDao vindicateDao;

	@Autowired
	private DormitoryUserDao dormitoryUserDao;

	@Override
	public ResultMessage wxLogin(UserPO po) {
		logger.trace("进入wxLogin方法");
		ResultMessage rs = new ResultMessage();
		try {
			//执行账号查找操作
			UserPO queryPo =new UserPO();
			queryPo.setUserName(po.getUserName());
			List<UserPO> pos = dao.getUsersByAccount(queryPo);
			if(pos.isEmpty()) {
				//设置性别
				po.setGender(po.getGender()==0?1:0);
				//头像转存到OSS对象存储服务器中
				String saveFileName = UUID.randomUUID() + "." + "jpg";
				String path = minio.putObject(saveFileName, po.getAvatarUrl());
				po.setAvatarUrl(path);
				//自动生成盐值与密码
				String salt = RandomStringUtils.randomAlphanumeric(20);
				po.setSalt(salt);
				po.setPassword(Encrypt.encrypt(queryPo.getUserName(),queryPo.getSalt()));
				dao.save(po);
			}else {
				po = dao.getUserByAccount(po.getUserName());
			}
			//进行登录操作
			List<String> roles = new ArrayList<>();
			List<RolePO>rolePos = roleDao.getRoleByUserName(po.getUserName());
			for(RolePO item: rolePos) {
				roles.add(item.getName());
			}
			// 如果用户角色为空，则默认赋予 ROLE_USER 角色
			if (CollectionUtils.isEmpty(roles)) {
				roles = Collections.singletonList(UserRoleConstants.ROLE_EDITOR);
			}
			Map<String,Object> credentials = new HashMap<String,Object>();
			credentials.put("user",po.getUserName());
			credentials.put("password",po.getPassword());
/*					Encrypt.setTempSalt(pos.get(0).getSalt());
					// 内部登录请求
		            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken( po.getUserName()
		            		, po.getPassword());*/
			// 验证
			String token = jwtTokenUtils.createToken(credentials, roles);
			Authentication auth = jwtTokenUtils.getAuthentication(token);//authenticationManager.authenticate(authRequest);
			SecurityContextHolder.getContext().setAuthentication(auth);
			Map<String, Object> param =new HashMap<>();
			param.put("token", token);
			po.setSalt(null);
			po.setUserName(null);
			po.setPassword(null);
			UserVO resVo = new UserVO();
			resVo.poToVo(po);
			param.put("user", resVo);
			rs.setCode(1L);
			rs.setData(param);
			rs.setMsg("登录成功!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			rs.setCode(1L);
			rs.setMsg("密码错误!");
		}catch (AuthenticationException e) {
			e.printStackTrace();
			rs.setCode(1L);
			rs.setMsg("验证错误!");
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("登录失败");
			rs.setCode(0L);
		}
		logger.trace("退出wxLogin方法");
		return rs;
	}
    @Override
    public ResultMessage login(UserPO po) {
    	logger.trace("进入login方法");
    	ResultMessage rs = new ResultMessage();
		try {
			//执行账号查找操作
			UserPO queryPo =new UserPO();
			queryPo.setUserName(po.getUserName());
			List<UserPO> pos = dao.getUsersByAccount(queryPo);
			if(pos.isEmpty()) {
				rs.setMsg("账号不存在!");
				rs.setCode(2L);
			}else {
				String beforPwd =  Encrypt.encrypt(po.getPassword(),pos.get(0).getSalt());
				if(StringUtils.equals(pos.get(0).getPassword(),beforPwd)) {
//				if( true) {
					List<String> roles = new ArrayList<>();
					List<RolePO>rolePos = roleDao.getRoleByUserName(po.getUserName());
					for(RolePO item: rolePos) {
						roles.add(item.getName());
					}
		            // 如果用户角色为空，则默认赋予 ROLE_USER 角色
		            if (CollectionUtils.isEmpty(roles)) {
		                roles = Collections.singletonList(UserRoleConstants.ROLE_EDITOR);
		            }
					Map<String,Object> credentials = new HashMap<String,Object>();
					credentials.put("user",queryPo.getUserName());
					credentials.put("password",po.getPassword());
/*					Encrypt.setTempSalt(pos.get(0).getSalt());
					// 内部登录请求
		            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken( po.getUserName()
		            		, po.getPassword());*/
		            // 验证
					String token = jwtTokenUtils.createToken(credentials, roles);
		            Authentication auth = jwtTokenUtils.getAuthentication(token);//authenticationManager.authenticate(authRequest);
		            SecurityContextHolder.getContext().setAuthentication(auth);
//		    	    Encrypt.setTempSalt("");
					Map<String, Object> param =new HashMap<>();
				    param.put("token", token);
					rs.setCode(1L);
					rs.setData(param);
					rs.setMsg("登录成功!");
				}else {
					rs.setCode(2L);
					rs.setMsg("密码错误!");
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			rs.setCode(1L);
			rs.setMsg("密码错误!");
		}catch (AuthenticationException e) { 
			e.printStackTrace();
			rs.setCode(1L);
			rs.setMsg("验证错误!");
        } catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("登录失败");
			rs.setCode(0L);
		}
		logger.trace("退出login方法");
		return rs;
    }

    @Override
    public ResultMessage register(UserPO po) {
    	logger.trace("进入register方法");
    	ResultMessage rs = new ResultMessage();
		try {
//			// 获取验证码
//			Map<String, Object> data = Registration.SendSms(po.getPhone().toString());
//			//判断短信发送是否成功
//			if (!data.get("Code").equals("OK")) {
//				throw new Exception();
//			}
			//发送成功则执行下列操作
//	    	new Thread(()->{
			synchronized(this) {
	    		UserPO queryPo =new UserPO();
				UserPO user =new UserPO();
				List<UserPO> pos = null;
				int i = 0;
				// 随机生成盐值
		        String salt = RandomStringUtils.randomAlphanumeric(20);
				do {
					Long lastId = dao.getLastId();
					if(!ObjectUtils.allNotNull(lastId)){
						lastId = 0L;
					}
					queryPo.setUserName(String.valueOf(10000+lastId.intValue() + i));
					pos = dao.getUsersByAccount(queryPo);			 					
					user.setUserName(queryPo.getUserName());
					i++;
				}while(!pos.isEmpty());
				user.setName(po.getName().equals(null)?queryPo.getUserName():po.getName());
				user.setGender(po.getGender());
//				user.setPassword(new BCryptPasswordEncoder().encode(salt+po.getPassword()));
				user.setPassword(Encrypt.encrypt(po.getPassword(),salt));
				user.setPhone(po.getPhone());
				user.setType(po.getType());
		        user.setSalt(salt);
		        System.out.println("创建账号：" + queryPo.getUserName());
		        dao.save(user);
				Map<String, Object> param =new HashMap<>();
				param.put("username", user.getUserName());
//					param.put("verifyCode", data.get("verifyCode"));
				rs.setCode(1L);
				rs.setData(param);
				rs.setMsg("注册成功!");
			}
//	        }).start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("注册失败");
			rs.setCode(0L);
		}
		logger.trace("退出register方法");
		return rs;
    }

	@Override
	public ResultMessage logout() {
		logger.trace("进入logout方法");
    	ResultMessage rs = new ResultMessage();
		try {
			rs.setCode(1L);
			rs.setMsg("登出成功!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("登出失败");
			rs.setCode(0L);
		}
		logger.trace("退出logout方法");
		return rs;
	}

	@Override
	public ResultMessage getList(PageRequest page, Integer type) {
		logger.trace("进入getList方法");
    	ResultMessage rs = new ResultMessage();
		try {
			Map<String,Object> data = new HashMap<String,Object>();
			String total =  ObjectUtils.allNotNull(type)?dao.getUserListSizByTye(type):
					dao.getUserListSize();
			if(ObjectUtils.allNotNull(page)){
				PageHelper.startPage(page.getPageNumber(), page.getPageSize());
			}
			List<UserPO> pos = ObjectUtils.allNotNull(type)?dao.getUserListByType(type):
					dao.getUserList();
			List<UserVO> vos = new ArrayList<>();
			pos.forEach((item)->{
				UserVO vo = new UserVO();
				vo.poToVo(item);
				vos.add(vo);
			});
			data.put("total", total);
			data.put("size", vos.size());
			data.put("data", vos);
			rs.setData(data);
			rs.setCode(1L);
			rs.setMsg("获取成功!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("获取失败");
			rs.setCode(0L);
		}
		logger.trace("退出getList方法");
		return rs;
	}

	@Override
	public ResultMessage getById(Long id) {
		logger.trace("进入 getById 方法");
    	ResultMessage rs = new ResultMessage();
		try {
			Map<String,Object> data = new HashMap<String,Object>();
			UserPO resPo = dao.getUserById(id);
			List<RolePO> roles = roleDao.getRoleByUserName(resPo.getUserName());
			List<String> roleVos = new ArrayList<String>();
//			UserRoleVO userVo = new UserRoleVO();
//			userVo.poToVo(resPo);
			roles.forEach(item->{
				roleVos.add(item.getName());
			});
//			userVo.setRoles(roleVos);
			UserVO resVo = new UserVO();
			resVo.setPassword(null);
			resVo.setSalt(null);
			resVo.poToVo(resPo);
			Long noteCount = noteDao.selectCount(new QueryWrapper<NotePO>().eq("user_id", resVo.getId()));
			Long vindicateCount = vindicateDao.selectCount(new QueryWrapper<VindicatePO>().eq("user_id", resVo.getId()));
			DormitoryUserPO dormitoryUser = dormitoryUserDao.selectOne(new QueryWrapper<DormitoryUserPO>().eq("user_id", resVo.getId()));
			data.put("noteCount",noteCount.toString());
			data.put("vindicateCount",vindicateCount.toString());
			data.put("dormitoryId", ObjectUtils.allNotNull(dormitoryUser)?dormitoryUser.getDormitoryId().toString():0);
			data.put("data",resVo);
			data.put("roles", roleVos);
			rs.setData(data);
			rs.setCode(1L);
			rs.setMsg("获取成功!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("获取失败");
			rs.setCode(0L);
		}
		logger.trace("退出 getById 方法");
		return rs;
	}

	@Override
	public ResultMessage update(UserPO po) {
		logger.trace("进入update方法");
    	ResultMessage rs = new ResultMessage();
		try {
			UserPO lastPo =dao.getUserById(po.getId());
			if (ObjectUtils.allNotNull(po.getName())) {
				lastPo.setName(po.getName());
			}
			if (ObjectUtils.allNotNull(po.getGender())) {
				lastPo.setGender(po.getGender());
			}
			if (ObjectUtils.allNotNull(po.getPhone())) {
				lastPo.setPhone(po.getPhone());
			}
			if (ObjectUtils.allNotNull(po.getAvatarUrl())) {
				lastPo.setAvatarUrl(po.getAvatarUrl());
			}
			if (ObjectUtils.allNotNull(po.getCarId())) {
				lastPo.setCarId(po.getCarId());
			}
			if (ObjectUtils.allNotNull(po.getNumber())) {
				lastPo.setNumber(po.getNumber());
			}
			if (ObjectUtils.allNotNull(po.getCarPicture())) {
				lastPo.setCarPicture(po.getCarPicture());
			}
			if (ObjectUtils.allNotNull(po.getIsLocked())) {
				lastPo.setIsLocked(po.getIsLocked());
			}
			if(dao.update(lastPo,new QueryWrapper<UserPO>().lambda().eq(UserPO::getId, lastPo.getId())) > 0 ) {
				rs.setCode(1L);
				rs.setMsg("修改成功!");
			}else {
				rs.setCode(1L);
				rs.setMsg("修改失败!");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("修改失败");
			rs.setCode(0L);
		}
		logger.trace("退出update方法");
		return rs;
	}

	@Override
	public ResultMessage updateCarId(UserPO po) {
		logger.trace("进入update方法");
		ResultMessage rs = new ResultMessage();
		try {
			if(!ObjectUtils.allNotNull(po)){
				logger.debug("Update Po must not null!");
				throw new IllegalArgumentException("Update Po must not null!");
			}
			if(!ObjectUtils.allNotNull(po.getCarId(), po.getCarPicture(), po.getId())){
				logger.debug("Update info must not null!");
				throw new IllegalArgumentException("Update Info must not null!");
			}
			if(dao.updateUserCar(po) > 0 ) {
				rs.setCode(1L);
				rs.setMsg("修改成功!");
			}else {
				rs.setCode(1L);
				rs.setMsg("修改失败!");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("修改失败");
			rs.setCode(0L);
		}
		logger.trace("退出update方法");
		return rs;
	}
	@Override
	public ResultMessage del(UserPO po) {
		logger.trace("进入del方法");
    	ResultMessage rs = new ResultMessage();
		try {
			if(dao.del(po) > 0 ) {
				rs.setCode(1L);
				rs.setMsg("删除成功!");
			}else {
				rs.setCode(1L);
				rs.setMsg("删除失败!");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("删除失败");
			rs.setCode(0L);
		}
		logger.trace("退出del方法");
		return rs;
	}

	@Override
	public ResultMessage resetPwd(UserPO po) {
		logger.trace("进入resetPwd方法");
    	ResultMessage rs = new ResultMessage();
		try {
			// 随机生成盐值
	        String salt = RandomStringUtils.randomAlphanumeric(20);
	        //重置密码为123456
			po.setPassword(Encrypt.encrypt("123456",salt));
			if(dao.resetPwd(po) > 0 ) {
				rs.setCode(1L);
				rs.setMsg("重置成功!");
			}else {
				rs.setCode(1L);
				rs.setMsg("重置失败!");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("重置失败");
			rs.setCode(0L);
		}
		logger.trace("退出resetPwd方法");
		return rs;
	}
}
