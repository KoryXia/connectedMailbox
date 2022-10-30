package com.noralsy.connected_mailbox.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.noralsy.connected_mailbox.entity.User;
import com.noralsy.connected_mailbox.entity.UserInfo;
import com.noralsy.connected_mailbox.entity.UserToken;
import com.noralsy.connected_mailbox.mapper.UserInfoMapper;
import com.noralsy.connected_mailbox.mapper.UserMapper;
import com.noralsy.connected_mailbox.mapper.UserTokenMapper;
import com.noralsy.connected_mailbox.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTokenMapper userTokenMapper;

    public Result getUserInfo(String id){
        try{
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", id);
            return new Result("success", userInfoMapper.selectOne(queryWrapper));
        }catch (Exception e){
            return new Result("User does not exist", null);
        }
    }

    public Result userLoginIn(User user){
        try{
            //Maybe encrypt and decrypt password here
            if(userMapper.getPassword(user.getPhone()).equals(user.getPassword())){
                QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("phone", user.getPhone());
                return new Result("success", userInfoMapper.selectOne(queryWrapper));
            }else {
                return new Result("failed", null);
            }
        }catch (Exception e){
            return new Result("failed", null);
        }

    }

    public Result updateToken(UserToken userToken){
        try {
            UpdateWrapper<UserToken> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("user_id", userToken.getUserId());
            userTokenMapper.update(userToken,updateWrapper);
            return new Result("success", null);
        }catch (Exception e){
            return new Result("failed",null);
        }
    }

    public Result getToken(String id){
        try{
            QueryWrapper<UserToken> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", id);
            return new Result("success", userTokenMapper.selectOne(queryWrapper));
        }catch (Exception e){
            return new Result("User does not exist", null);
        }
    }
}
