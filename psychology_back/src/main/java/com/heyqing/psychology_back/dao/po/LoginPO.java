package com.heyqing.psychology_back.dao.po;

import lombok.Data;

/**
 * ClassName:LoginPO
 * Package:com.heyqing.psychology_back.dao.po
 * Description:
 *
 * @Date:2024/3/11
 * @Author:Heyqing
 */
@Data
public class LoginPO {


    /**
     * 用户登录凭证
     */
    private String code;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户头像地址
     */
    private String avatarUrl;
}
