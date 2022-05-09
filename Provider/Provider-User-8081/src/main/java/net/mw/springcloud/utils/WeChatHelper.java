package net.mw.springcloud.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import net.mw.springcloud.pojo.vo.WXAppidAndSecretVO;
import net.mw.springcloud.pojo.vo.WXUserInfoVO;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;



@Component
public class WeChatHelper {

    public static boolean initialized = false;
    private static boolean hasInited = false;
    private static String weChatLoginUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
    private static String staticAppid;
    private static String staticSecret;


    @Value("${wx.appid}")
    public void setAppid(String appid) {
        staticAppid = appid;
    }

    @Value("${wx.secret}")
    public void setDatabase(String secret) {
        staticSecret = secret;
    }

    /**
     * openid.
     *
     * @param jsCode
     * @return
     */
    public static String getOpenid(String jsCode) {
    	
        String openid = null;
        
        if (jsCode != null && jsCode != "") {

            try {
                String url_parms = fillingParameters(jsCode);

                Map<String, Object> responeMap = HttpHelper.sendGet(url_parms, "UTF-8");
                
                String responseCode = (String) responeMap.get("response_code");
                
                if (responseCode.equals("200")) {
                	
                	String responseParam = (String) responeMap.get("response_data");
                	
                    Gson gs = new Gson();
                    WXAppidAndSecretVO WXAppidAndSecretVo = gs.fromJson(responseParam,
                    		WXAppidAndSecretVO.class);
                    
                    openid = WXAppidAndSecretVo.getOpenid();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return openid;
    }

    /**
     * 获取微信的SessionKey.
     * @param jsCode 需要解析的数据.
     *
     */
    public static WXAppidAndSecretVO getSessionKey(String jsCode) {
        if (jsCode != null && jsCode != "") {
            String url_parms = null;
            try {
                url_parms = fillingParameters(jsCode);
                String encoding = "UTF-8";

                Map<String, Object> responeMap = HttpHelper.sendGet(url_parms,encoding);

                String responseCode = (String) responeMap.get("response_code");

                if (responseCode.equals("200")) {

                    String responseParam = (String) responeMap.get("response_data");

                    Gson gs = new Gson();
                    WXAppidAndSecretVO wxAppidAndSecretVo = gs.fromJson(responseParam,
                            WXAppidAndSecretVO.class);

                    if (wxAppidAndSecretVo.getErrcode() == null) {
                        return wxAppidAndSecretVo;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	/**
	 * 对URL进行参数封装
     *
     * @param jsCode 需要解析的参数.
     * @return
	 * @throws Exception
     */
    private static String fillingParameters(String jsCode) throws Exception {
    	//获取APPID，APPSECRET
    	StringBuilder string = new StringBuilder();
        return weChatLoginUrl.replaceFirst("APPID", staticAppid)
                .replaceFirst("JSCODE", jsCode).replaceFirst("SECRET", staticSecret);
    }
 
    /**
     * 获取解密后用户信息
     *
     * @param encData
     * @param iv
     * @param session_key
     * @return
     * @throws Exception
     */
    public static WXUserInfoVO getUserInfoAndIsExist(String encData, String iv,
                                                     String session_key) {
        Gson gson = new Gson();
        try {
            String userInfo = decrypt(session_key, iv, encData);
            WXUserInfoVO t = gson.fromJson(userInfo, WXUserInfoVO.class);
            return t;

        } catch (Exception ignored) {

        }
        return null;
    }

    private static String decrypt(String session_key, String iv,
                                  String encryptData) {
        String result = "";
        init2();
        byte[] keyByte = Base64.decodeBase64(session_key);
        byte[] ivByte = Base64.decodeBase64(iv);
        byte[] dataByte = Base64.decodeBase64(encryptData);

        try {
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base
                        + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters
                    .getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                result = new String(resultByte, "UTF-8");
            }
        } catch (Exception e) {

        }
        return result;

    }

    public static void init2() {
    	if (hasInited) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        hasInited = true;
    }


}
