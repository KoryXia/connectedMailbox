package com.noralsy.connected_mailbox.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noralsy.connected_mailbox.entity.Letter;
import com.noralsy.connected_mailbox.mapper.LetterMapper;
import com.noralsy.connected_mailbox.utils.BaseResult;
import com.noralsy.connected_mailbox.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterService {
    @Autowired
    private LetterMapper letterMapper;

    public BaseResult<List<Letter>> getAllLettersByMailboxId(String id) {
        try {
            QueryWrapper<Letter> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("mailbox_id", id);
            List<Letter> letterList = letterMapper.selectList(queryWrapper);
            if (letterList.size() == 0) {
                return ResultUtil.error("No letter");
            } else {
                return ResultUtil.success(letterList);
            }
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }
}
