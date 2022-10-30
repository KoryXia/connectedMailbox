package com.noralsy.connected_mailbox.controller;

import com.noralsy.connected_mailbox.service.LetterService;
import com.noralsy.connected_mailbox.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/letter")
public class LetterController {
    @Autowired
    private LetterService letterService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getAllLettersByMailboxId(@PathVariable String id){
        return letterService.getAllLettersByMailboxId(id);
    }
}
