package com.noralsy.connected_mailbox.controller;


import com.noralsy.connected_mailbox.entity.User;
import com.noralsy.connected_mailbox.entity.UserInfo;
import com.noralsy.connected_mailbox.entity.UserToken;
import com.noralsy.connected_mailbox.service.UserService;
import com.noralsy.connected_mailbox.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseResult<UserInfo> getUserInfo(@PathVariable String id) {
        return userService.getUserInfo(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult<UserInfo> userLogin(User user) {
        return userService.userLogin(user);
    }

    @RequestMapping(value = "/updateToken", method = RequestMethod.POST)
    public BaseResult<Object> updateToken(UserToken userToken) {
        return userService.updateToken(userToken);
    }

    @RequestMapping(value = "/checkToken", method = RequestMethod.POST)
    public BaseResult<String> checkToken(UserToken userToken) {
        return userService.checkToken(userToken.getUserId(), userToken.getToken());
    }
}
