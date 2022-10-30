package com.noralsy.connected_mailbox.controller;

import com.noralsy.connected_mailbox.entity.Mailbox;
import com.noralsy.connected_mailbox.service.MailboxService;
import com.noralsy.connected_mailbox.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mailbox")
public class MailboxController {
    @Autowired
    private MailboxService mailboxService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getAllMailboxByUserId(@PathVariable String id){
        return mailboxService.getAllMailboxsByUserId(id);
    }

    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    public Result bindMailbox(Mailbox mailbox){
        return mailboxService.bindMailbox(mailbox);
    }
}
