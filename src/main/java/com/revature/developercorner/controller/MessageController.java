package com.revature.developercorner.controller;

import com.revature.developercorner.dto.MessageDto;
import com.revature.developercorner.dto.QuestionDto;
import com.revature.developercorner.entity.Message;
import com.revature.developercorner.entity.Question;
import com.revature.developercorner.service.MessageService;
import com.revature.developercorner.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/message")
public class MessageController {
    @Autowired
    MessageService messageService;


    @PostMapping("/addmessage")
    public MessageDto addMessage(@RequestBody MessageDto messageDto) {
        System.out.println(messageDto);
        Message message = new Message();
        message.setMessage(messageDto.getMessage());
        message.setSender(messageDto.getSender());
        message.setRecipient(messageDto.getRecipient());
        message = messageService.addMessage(message);

        messageDto.setId(message.getId());
        messageDto.setError_or_success("SUCCESS");
        System.out.println(message);

        return messageDto;
    }

    @PostMapping("/updatemessage")
    public MessageDto updateMessage(@RequestBody MessageDto messageDto) {
        System.out.println(messageDto);
        Message message = new Message();
        message.setMessage(messageDto.getMessage());
        message.setSender(messageDto.getSender());
        message.setRecipient(messageDto.getRecipient());


        System.out.println(message);
        messageDto.setError_or_success("SUCCESS");
        return messageDto;
    }

    @PostMapping("/deletemessage")
    public MessageDto deleteMessage(@RequestBody MessageDto messageDto) {
        System.out.println(messageDto);
        messageService.delete(messageDto.getId());
        messageDto.setError_or_success("SUCCESS");
        return messageDto;
    }

    @GetMapping("/listmessage")
    public List listmessage(@RequestBody MessageDto messageDto) {
        List<Message> messages = messageService.getAll();
        List messageDtolist = new ArrayList();

        if (messages != null) {
            messages.forEach(message -> {
                MessageDto messageDto1 = new MessageDto();
                messageDto1.setId(message.getId());

                messageDto1.setMessage(message.getMessage());
                messageDto1.setSender(message.getSender());
                messageDto1.setRecipient(message.getRecipient());

                messageDtolist.add(messageDto);
            });
        }
        return messageDtolist;
    }
}