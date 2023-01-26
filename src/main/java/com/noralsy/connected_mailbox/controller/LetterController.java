package com.noralsy.connected_mailbox.controller;

import com.noralsy.connected_mailbox.entity.Letter;
import com.noralsy.connected_mailbox.service.LetterService;
import com.noralsy.connected_mailbox.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/letter")
public class LetterController {
    @Autowired
    private LetterService letterService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseResult<List<Letter>> getAllLettersByMailboxId(@PathVariable String id){
        return letterService.getAllLettersByMailboxId(id);
    }

    @RequestMapping(value = "/insert_new_letter/{id}", method = RequestMethod.GET)
    public BaseResult<Letter> insertLetter(@PathVariable String id) {
        return this.letterService.insertLetter(id);
    }
}
