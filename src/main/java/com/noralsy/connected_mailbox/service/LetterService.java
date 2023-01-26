package com.noralsy.connected_mailbox.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noralsy.connected_mailbox.entity.Letter;
import com.noralsy.connected_mailbox.mapper.LetterMapper;
import com.noralsy.connected_mailbox.utils.BaseResult;
import com.noralsy.connected_mailbox.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public BaseResult<Letter> insertLetter(String id) {
        Letter newLetter = new Letter();
        newLetter.setDateTime(new Timestamp(new Date().getTime()));
        newLetter.setMailboxId(id);
        try {
            letterMapper.insert(newLetter);
            return ResultUtil.success(newLetter);
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }
}
