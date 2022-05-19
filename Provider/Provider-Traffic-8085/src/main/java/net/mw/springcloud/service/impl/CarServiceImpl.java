package net.mw.springcloud.service.impl;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import io.jsonwebtoken.lang.Collections;
import net.mw.springcloud.ProviderTrafficApplication;
import net.mw.springcloud.dao.CarDao;
import net.mw.springcloud.easypr.core.CharsRecognise;
import net.mw.springcloud.easypr.core.PlateDetect;
import net.mw.springcloud.pojo.po.CarPO;
import net.mw.springcloud.pojo.po.UserPO;
import net.mw.springcloud.pojo.vo.CarVO;
import net.mw.springcloud.result.ResultMessage;
import net.mw.springcloud.service.CarService;
import net.mw.springcloud.utils.MinioHelper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bytedeco.javacpp.opencv_core;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

import static org.bytedeco.javacpp.opencv_highgui.imread;

/**
 * @Description TaskServiceImpl接口实现
 * @Author W_Messi
 * @CrateTime 2021-03-06 21:30:03
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarDao, CarPO> implements CarService {

	/**
	 * log4j实例对象.
	 */
	private static Logger logger = LogManager.getLogger(CarServiceImpl.class);
	
	@Autowired
	private CarService dao;

	@Autowired
    private MinioHelper minioHelper;
    /**
     *  识别车牌
     * 2022年5月14日
     * String
     */
    public String recognize(String image) {
        String res = null;
//    	org.bytedeco.javacpp.Loader t;
//        System.out.println("Current: " + image);
		logger.info("Current: " + image);
        opencv_core.Mat src = imread(image);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<opencv_core.Mat> matVector = new Vector<opencv_core.Mat>();
        int recoginzeResult=plateDetect.plateDetect(src, matVector);
        if (0 == recoginzeResult) {
            CharsRecognise cr = new CharsRecognise();
            for (int i = 0; i < matVector.size(); ++i) {
                String result = cr.charsRecognise(matVector.get(i));
                res = result;
                logger.info("Chars Recognised: " + result);
            }
        }else{
			logger.info("recoginzeResult: " + recoginzeResult);
        }
        return res;
    }

	@Override
	public ResultMessage getCode(MultipartFile image) {
		logger.trace("进入getCode方法");
		ResultMessage rs = new ResultMessage();
		try {
			if(!ObjectUtils.allNotNull(image) || image.isEmpty()){
				logger.debug("CurrentUser must not null!");
				throw new IllegalArgumentException("CurrentUser must not null!");
			}
			if(!image.getContentType().contains("image")){
				logger.debug("File must image!");
				throw new IllegalArgumentException("File must image!");
			}
			String fileName = image.getOriginalFilename();
			File path = null;
            URL url = ProviderTrafficApplication.class.getResource("");
            String protocol = url.getProtocol();
            //判断是否在JAR包环境下
            if("jar".equals(protocol)){
                //JAR包环境下设置为同级目录下的config为父目录
                path = FileUtil.file(".", "config/tmp/" );
                logger.error(path.getAbsolutePath());
            }else{
				path = new File("tmp");
            }
			if(!path.exists()){
				path.mkdirs();
			}
			File dest = new File(path.getAbsolutePath()+ "//" + fileName);
			dest.createNewFile();
//			image.transferTo(dest);
            FileUtils.copyInputStreamToFile(image.getInputStream(),dest);
			String number = recognize(dest.getAbsolutePath());
			if(ObjectUtils.allNotNull(number)){
				Map<String,Object> data = new HashMap<String,Object>();
				CarPO car = new CarPO();
				car.setNumber(number);
				if(dest.exists()){
					dest.delete();
				}
				data.put("code", number);
                data.put("path", this.minioHelper.putObject(image));
				if(dao.count(new QueryWrapper<CarPO>().eq("number", number)) == 0){
                    data.put("state", dao.save(car));
                    rs.setMsg("识别成功!");
                }else{
                    rs.setMsg("车牌已存在!");
                }
				rs.setData(data);
				rs.setCode(1L);
				rs.setMsg("识别成功!");
			}else{
				rs.setCode(2L);
				rs.setMsg("识别失败!");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("识别失败");
			rs.setCode(0L);
		} finally  {
            System.gc();
        }
		logger.trace("退出 getCode 方法");
		return rs;
	}

	@Override
	public ResultMessage getList(PageRequest page, UserPO user) {
		logger.trace("进入getList方法");
    	ResultMessage rs = new ResultMessage();
		try {
			if(!ObjectUtils.allNotNull(user)){
				logger.debug("CurrentUser must not null!");
				throw new IllegalArgumentException("CurrentUser must not null!");
			}
			Map<String,Object> data = new HashMap<String,Object>();
			if(ObjectUtils.allNotNull(page) && ObjectUtils.allNotNull(page.getPageNumber(), page.getPageSize())){
				PageHelper.startPage(page.getPageNumber(), page.getPageSize());
			}
			List<CarPO> pos = dao.list();
			List<CarVO> vos = new ArrayList<>();
			pos.forEach((item)->{
				CarVO vo = new CarVO();
				vo.poToVo(item);
				vos.add(vo);
			});
			data.put("total",  dao.count());
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
	public ResultMessage getByPoId(Long id) {
		logger.trace("进入 getById 方法");
    	ResultMessage rs = new ResultMessage();
		try {
			if(!ObjectUtils.allNotNull(id)){
				logger.debug("id must not null!");
				throw new IllegalArgumentException("id must not null!");
			}
			Map<String,Object> data = new HashMap<String,Object>();
			CarPO resPo = dao.getById(id);
			CarVO resVo = new CarVO();
			if(ObjectUtils.allNotNull(resPo)){
				resVo.poToVo(resPo);
			}
			data.put("data",resVo);
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
	public ResultMessage savePo(CarPO po) {
		logger.trace("进入 save 方法");
    	ResultMessage rs = new ResultMessage();
		try {
			if(!ObjectUtils.allNotNull(po)){
				logger.debug("po must not null!");
				throw new IllegalArgumentException("po must not null!");
			}
			if(dao.saveOrUpdate(po)) {
				rs.setCode(1L);
				rs.setMsg("操作成功!");
			}else {
				rs.setCode(1L);
				rs.setMsg("添加失败!");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			rs.setMsg("参数不正确");
			rs.setCode(2L);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg("添加失败");
			rs.setCode(0L);
		}
		logger.trace("退出add方法");
		return rs;
	}

	@Override
	public ResultMessage delByIds(String[] ids) {
		logger.trace("进入 delByIds 方法");
    	ResultMessage rs = new ResultMessage();
		try {
			if(!ObjectUtils.allNotNull(ids)){
				logger.debug("ids must not null!");
				throw new IllegalArgumentException("ids must not null!");
			}
			if(dao.removeBatchByIds(Collections.arrayToList(ids))) {
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
		logger.trace("退出 delByIds 方法");
		return rs;
	}

}
