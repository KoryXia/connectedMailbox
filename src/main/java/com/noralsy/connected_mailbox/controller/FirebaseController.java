package com.noralsy.connected_mailbox.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.noralsy.connected_mailbox.service.FirebaseService;
import com.noralsy.connected_mailbox.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firebase")
public class FirebaseController {
    @Autowired
    private FirebaseService firebaseService;

    @RequestMapping(value = "/creatNotification", method = RequestMethod.GET)
    public BaseResult<String> creatNotification(@RequestParam String token) throws FirebaseMessagingException {
        return this.firebaseService.creatNotification(token);
    }
}
