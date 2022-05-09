package net.mw.springcloud.pojo.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取微信登录信息
 *
 * @author 张剑民
 * @since 6.0.0
 */
@Getter
@Setter
public class WXAppidAndSecretVO {

    private String openid;
    
    private String session_key;
    
    private String errcode;
    
    private String errmsg;
    
    private String uinionid;

}
