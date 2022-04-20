package net.mw.springcloud.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description 用户实体
 * @author W_Messi
 * @CreateTime 2020/3/2 12:02
 *
 */
@Data
public class UserRoleVO extends UserVO {
    private List<String> roles;
}
