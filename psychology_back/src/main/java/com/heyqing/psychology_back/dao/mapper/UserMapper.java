package com.heyqing.psychology_back.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heyqing.psychology_back.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName:UserMapper
 * Package:com.heyqing.psychology_back.dao.mapper
 * Description:
 *
 * @Date:2024/3/11
 * @Author:Heyqing
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
