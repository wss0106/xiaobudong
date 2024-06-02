package com.wss.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wss.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weishuaishuai
 * @since 2024-05-23
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    UserDO selectOne(@Param("id") String id);
}
