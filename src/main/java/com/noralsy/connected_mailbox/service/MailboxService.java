package com.noralsy.connected_mailbox.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.noralsy.connected_mailbox.entity.Mailbox;
import com.noralsy.connected_mailbox.mapper.MailboxMapper;
import com.noralsy.connected_mailbox.utils.BaseResult;
import com.noralsy.connected_mailbox.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailboxService {
    @Autowired
    private MailboxMapper mailboxMapper;

    public BaseResult<List<Mailbox>> getAllMailboxsByUserId(String id) {
        try {
            QueryWrapper<Mailbox> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", id);
            List<Mailbox> mailboxes = mailboxMapper.selectList(queryWrapper);
            if (mailboxes.size() == 0) {
                return ResultUtil.error("No mailbox");
            } else {
                return ResultUtil.success(mailboxes);
            }
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }

    public BaseResult<Mailbox> bindMailbox(Mailbox mailbox) {
        try {
            mailboxMapper.insert(mailbox);
            return ResultUtil.success(mailbox);
        } catch (Exception e) {
            return ResultUtil.error("This mailbox has been bound");
        }
    }

    public BaseResult<String> updateState(String id) {
        try {
            QueryWrapper<Mailbox> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("mailbox_id", id);
            Mailbox mailbox = mailboxMapper.selectOne(queryWrapper);
            UpdateWrapper<Mailbox> updateWrapper = new UpdateWrapper<>();
            if (!mailbox.getGotNew()) {
                updateWrapper.eq("mailbox_id", id).set("got_new", !mailbox.getGotNew());
                mailboxMapper.update(null, updateWrapper);
            }
            return ResultUtil.success(id);
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }
}
