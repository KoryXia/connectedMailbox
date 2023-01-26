package com.noralsy.connected_mailbox.controller;

import com.noralsy.connected_mailbox.entity.Mailbox;
import com.noralsy.connected_mailbox.service.MailboxService;
import com.noralsy.connected_mailbox.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/mailbox")
public class MailboxController {
    @Autowired
    private MailboxService mailboxService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseResult<List<Mailbox>> getAllMailboxByUserId(@PathVariable String id){
        return mailboxService.getAllMailboxsByUserId(id);
    }

    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    public BaseResult<Mailbox> bindMailbox(Mailbox mailbox){
        return mailboxService.bindMailbox(mailbox);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public BaseResult<String> updateState(@PathVariable String id){
        return mailboxService.updateState(id);
    }
}
