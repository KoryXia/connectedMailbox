package com.noralsy.connected_mailbox.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noralsy.connected_mailbox.entity.UserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {
}