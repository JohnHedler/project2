package com.revature.developercorner.service;

import com.revature.developercorner.data.MessageRepository;
import com.revature.developercorner.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public Message add_Message(Message message){
        messageRepository.save(message);
        return message;
    }

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Message getById(Message message, Long id) {
        messageRepository.findById(id).get();
        return message;
    }

    public void update(Message message, Long id) {
        Message messageDB = messageRepository.findById(id).get();
        messageDB.setMessage(message.getMessage());
        messageDB.setSender(message.getSender());
        messageDB.setRecipient(message.getRecipient());
        messageRepository.save(messageDB);
    }

    public void delete(Long id) {
        messageRepository.deleteById(id);
    }

<<<<<<< HEAD

=======
    public List<Message> get_All_Messages(){
        return messageRepository.findAll();
    }


    public List<Message> get_Message_custom(String flag) {
        switch(flag){
            case "new":
                return messageRepository.findByDate();
            case "old":
                return messageRepository.findByDate();
            default:
                return get_All_Messages();
        }
    }


    public Message get_Message_by_id(Long id) {
        return messageRepository.findById(id).get();
    }

    public Message update_message(Message message, Long id) {
        Message messageDB = messageRepository.findById(id).get();
        messageDB.setQuestion(message.getQuestion());
        messageDB.setTime(message.getTime());
        messageDB.setAuthor(message.getAuthor());
        messageRepository.save(messageDB);
        return messageDB;
    }

    public void delete_message(Long id) {
        messageRepository.deleteById(id);
    }
>>>>>>> 0bf414c76778759f259a3c44b3b5898cad6550a7
}
