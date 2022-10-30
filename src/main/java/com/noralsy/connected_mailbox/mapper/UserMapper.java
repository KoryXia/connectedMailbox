package com.noralsy.connected_mailbox.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noralsy.connected_mailbox.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select password from user where phone=#{phone}")
    String getPassword(String phone);
}
