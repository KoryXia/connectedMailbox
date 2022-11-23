package com.noralsy.connected_mailbox.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.noralsy.connected_mailbox.utils.BaseResult;
import com.noralsy.connected_mailbox.utils.ResultUtil;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {
    public BaseResult<String> creatNotification(String title, String body, String token) throws FirebaseMessagingException {
        Notification notification = Notification
                .builder()
                .setTitle(title)
                .setBody(body)
                .build();
        Message message = Message.builder()
                .setNotification(notification)
                .setToken(token)
                .build();
        String response = FirebaseMessaging.getInstance().send(message);
        return ResultUtil.success(response);
    }
}
