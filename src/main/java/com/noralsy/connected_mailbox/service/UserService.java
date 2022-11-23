package com.noralsy.connected_mailbox.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.noralsy.connected_mailbox.entity.User;
import com.noralsy.connected_mailbox.entity.UserInfo;
import com.noralsy.connected_mailbox.entity.UserToken;
import com.noralsy.connected_mailbox.mapper.UserInfoMapper;
import com.noralsy.connected_mailbox.mapper.UserMapper;
import com.noralsy.connected_mailbox.mapper.UserTokenMapper;
import com.noralsy.connected_mailbox.utils.BaseResult;
import com.noralsy.connected_mailbox.utils.ResultUtil;
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

    public BaseResult<UserInfo> getUserInfo(String id) {
        try {
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", id);
            UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
            if (userInfo == null) {
                return ResultUtil.error("User does not exist");
            } else {
                return ResultUtil.success(userInfo);
            }
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }

    public BaseResult<UserInfo> userLogin(User user) {
        try {
            //Maybe encrypt and decrypt password here
            if (userMapper.getPassword(user.getPhone()).equals(user.getPassword())) {
                QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("phone", user.getPhone());
                return ResultUtil.success(userInfoMapper.selectOne(queryWrapper));
            } else {
                return ResultUtil.error("incorrect_info");
            }
        } catch (Exception e) {
            return ResultUtil.error("null_user");
        }

    }

    public BaseResult<Object> updateToken(UserToken userToken) {
        try {
            UpdateWrapper<UserToken> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("user_id", userToken.getUserId());
            userTokenMapper.update(userToken, updateWrapper);
            return ResultUtil.success(null);
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }

    public BaseResult<String> checkToken(String id, String token) {
        try {
            QueryWrapper<UserToken> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", id);
            UserToken userToken = userTokenMapper.selectOne(queryWrapper);
            if (userToken == null) {
                return ResultUtil.error("User does not exist");
            } else {
                if(userToken.getToken().equals(token)){
                    return ResultUtil.success("same");
                }
                return ResultUtil.success("diff");
            }
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }

    public BaseResult<String> changePassword(String phone, String password) {
        try {
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("phone", phone);
            userMapper.update(new User(phone, password), updateWrapper);
            return ResultUtil.success("success");
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }

}
