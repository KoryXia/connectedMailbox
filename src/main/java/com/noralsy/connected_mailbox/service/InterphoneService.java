package com.noralsy.connected_mailbox.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.noralsy.connected_mailbox.entity.Interphone;
import com.noralsy.connected_mailbox.mapper.InterphoneMapper;
import com.noralsy.connected_mailbox.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InterphoneService {
    @Autowired
    private InterphoneMapper interphoneMapper;

    public Result getAllInterphones(){
        try{
            Page<Interphone> page = new Page<>(0,10);
            return new Result("success", interphoneMapper.selectPage(page,null));
        }catch (Exception e){
            return new Result("failed", null);
        }
    }

    public Result getInterphoneById(String id){
        try{
            QueryWrapper<Interphone> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("interphone_id",id);
            return new Result("success", interphoneMapper.selectOne(queryWrapper));
        }catch (Exception e){
            return new Result("Interphone does not exist", null);
        }
    }
}
