package com.mirjalal.devopsdemo.service;

import com.mirjalal.devopsdemo.model.Message;
import com.mirjalal.devopsdemo.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    public void createMessage(String text) {
        Message message = new Message();
        message.setText(text);
        messageRepository.save(message);
    }

    public Iterable<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
