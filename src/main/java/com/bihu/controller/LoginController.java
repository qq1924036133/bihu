package com.bihu.controller;

import com.bihu.model.MessageCode;
import com.bihu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    MessageService messageService;
    @Autowired
    MessageCode messageCode;

    @RequestMapping(path = {"/"})
    public String login() {
        return "login.html";
    }

    @RequestMapping(path = {"/reg/"}, method = {RequestMethod.POST})
    public String reg(String mobile, String password) {
        messageService.sendMessageCode(mobile, messageCode);
        return "redirect:/index.html";
    }



}
