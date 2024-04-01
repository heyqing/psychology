package com.heyqing.psychology_back.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * ClassName:UserEntity
 * Package:com.heyqing.psychology_back.dao.entity
 * Description:
 *
 * @Date:2024/3/11
 * @Author:Heyqing
 */
@Data
@TableName(value = "psy_user")
public class UserEntity {

    /**
     * userId
     */
    @TableId(value = "id")
    private Long id;
    /**
     * openid用户唯一标识
     */
    @TableField(value = "openid")
    private String openid;
    /**
     * 用户昵称
     */
    @TableField(value = "nickname")
    private String nickname;
    /**
     * 用户头像地址
     */
    @TableField(value = "avatar_url")
    private String avatarUrl;
    /**
     * 用户注册时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 用户最后登录时间
     */
    @TableField(value = "last_time")
    private Date lastTime;


}
