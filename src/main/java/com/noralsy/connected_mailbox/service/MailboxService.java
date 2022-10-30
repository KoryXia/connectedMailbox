package com.noralsy.connected_mailbox.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noralsy.connected_mailbox.entity.Mailbox;
import com.noralsy.connected_mailbox.mapper.MailboxMapper;
import com.noralsy.connected_mailbox.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailboxService {
    @Autowired
    private MailboxMapper mailboxMapper;

    public Result getAllMailboxsByUserId(String id) {
        try {
            QueryWrapper<Mailbox> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", id);
            return new Result("success", mailboxMapper.selectList(queryWrapper));
        }catch (Exception e){
            return new Result("failed", null);
        }
    }

    public Result bindMailbox(Mailbox mailbox) {
        try {
            mailboxMapper.insert(mailbox);
            return new Result("success", mailbox);
        } catch (Exception e) {
            return new Result("failed", null);
        }
    }
}