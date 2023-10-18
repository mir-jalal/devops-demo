package com.mirjalal.devopsdemo.controller;

import com.mirjalal.devopsdemo.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class IndexController {

    private final MessageService messageService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("messages", messageService.getAllMessages());
        return "index";
    }

    @PostMapping("/createMessage")
    public String createMessage(@RequestParam String message, Model model){
        messageService.createMessage(message);
        return this.index(model);
    }
}
