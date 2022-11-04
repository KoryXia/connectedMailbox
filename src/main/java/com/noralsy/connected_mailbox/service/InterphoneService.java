package com.noralsy.connected_mailbox.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.noralsy.connected_mailbox.entity.Interphone;
import com.noralsy.connected_mailbox.mapper.InterphoneMapper;
import com.noralsy.connected_mailbox.utils.BaseResult;
import com.noralsy.connected_mailbox.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InterphoneService {
    @Autowired
    private InterphoneMapper interphoneMapper;

    public BaseResult<Page<Interphone>> getAllInterphones(){
        try{
            Page<Interphone> page = new Page<>(0,10);
            return ResultUtil.success(interphoneMapper.selectPage(page,null));
        }catch (Exception e){
            return ResultUtil.error();
        }
    }

    public BaseResult<Interphone> getInterphoneById(String id){
        try{
            QueryWrapper<Interphone> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("interphone_id",id);
            Interphone interphone = interphoneMapper.selectOne(queryWrapper);
            if (interphone == null) {
                return ResultUtil.error("Interphone does not exist");
            } else {
                return ResultUtil.success(interphone);
            }
        }catch (Exception e){
            return ResultUtil.error();
        }
    }
}
