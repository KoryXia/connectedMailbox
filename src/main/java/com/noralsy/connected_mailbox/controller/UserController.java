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

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public BaseResult<UserInfo> userLoginIn(User user) {
        return userService.userLoginIn(user);
    }

    @RequestMapping(value = "/updateToken", method = RequestMethod.POST)
    public BaseResult<Object> updateToken(UserToken userToken) {
        return userService.updateToken(userToken);
    }

    @RequestMapping(value = "/getUserToken", method = RequestMethod.GET)
    public BaseResult<UserToken> getUserToken(@RequestParam String id) {
        return userService.getToken(id);
    }
}
