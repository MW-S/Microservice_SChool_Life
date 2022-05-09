/**
 * Copyright (c) 2014 Wteamfly.  All rights reserved. 网飞公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package net.mw.springcloud.pojo.vo;

import lombok.Getter;
import lombok.Setter;

/**
 *  微信用户解密后的信息
 * 
 * @since 5.0.4
 *      linpr
 *
 */
@Getter
@Setter
public class WXUserInfoVO {

    /**
     * openId : OPENID
     * nickName : NICKNAME
     * gender : GENDER
     * city : CITY
     * province : PROVINCE
     * country : COUNTRY
     * avatarUrl : AVATARURL
     * unionId : UNIONID
     * watermark : {"appid":"APPID","timestamp":"TIMESTAMP"}
     */
	
	private String type;
	
	private String userId;
	
    private String openId;
    
    private String nickName;
    
    private String gender;
    
    private String city;
    
    private String province;
    
    private String country;
    
    private String avatarUrl;
    
    private String unionId;

    private WatermarkBean watermark;
    
    //用户头像文件名
    private String avatarname;
    
    @Getter
    @Setter
    public static class WatermarkBean {
        /**
         * appid : APPID
         * timestamp : TIMESTAMP
         */

        private String appid;
        private String timestamp;

    }

    public UserVO toUserVO(){
        UserVO vo = new UserVO();
        vo.setAvatarUrl(this.avatarUrl);
        vo.setGender(this.gender);
        vo.setName(this.nickName);
        vo.setUserName(this.openId);
        vo.setType("0");
        return vo;
    }
}
