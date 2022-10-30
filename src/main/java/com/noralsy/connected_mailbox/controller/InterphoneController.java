package com.noralsy.connected_mailbox.controller;

import com.noralsy.connected_mailbox.service.InterphoneService;
import com.noralsy.connected_mailbox.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interphone")
public class InterphoneController {
    @Autowired
    private InterphoneService interphoneService;
    @RequestMapping(value = "/getAllInterphones", method = RequestMethod.GET)
    public Result getAllInterphones(){
        return this.interphoneService.getAllInterphones();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getInterphoneById(@PathVariable String id){
        return interphoneService.getInterphoneById(id);
    }
}
