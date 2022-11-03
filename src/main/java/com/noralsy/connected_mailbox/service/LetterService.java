package com.noralsy.connected_mailbox.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noralsy.connected_mailbox.entity.Letter;
import com.noralsy.connected_mailbox.mapper.LetterMapper;
import com.noralsy.connected_mailbox.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterService {
    @Autowired
    private LetterMapper letterMapper;

    public Result getAllLettersByMailboxId(String id) {
        try {
            QueryWrapper<Letter> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("mailbox_id", id);
            List<Letter> letterList = letterMapper.selectList(queryWrapper);
            if (letterList.size() == 0) {
                return new Result("No letter", null);
            } else {
                return new Result("success", letterMapper.selectList(queryWrapper));
            }
        } catch (Exception e) {
            return new Result("failed", e.getClass());
        }
    }
}
