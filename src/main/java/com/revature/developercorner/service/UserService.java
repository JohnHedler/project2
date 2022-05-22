package com.revature.developercorner.service;


import com.revature.developercorner.data.TechStackRepository;
import com.revature.developercorner.data.UserRepository;
import com.revature.developercorner.dto.UserDto;
import com.revature.developercorner.entity.TechStack;
import com.revature.developercorner.entity.User;
import com.revature.developercorner.entity.UserTechStack;
import com.revature.developercorner.entity.UserTechStackMapId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TechStackRepository techStackRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(User user, Long id) {
        return userRepository.findById(id).get();
    }

    public User getByUserId(User user, Long id) {
        return userRepository.findById(id).get();
    }

    public User addUser(User user) {
        userRepository.save(user);
        return (user);
    }

    public void update_user(User user, Long id) {
        User userDB = userRepository.findById(id).get();
        userDB.setUsername(user.getUsername());
        userDB.setPassword(user.getPassword());
        userDB.setEMail(user.getEMail());
        userRepository.save(userDB);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUserTechStack(UserDto userdto) {
        List<Long> techStacks = userdto.getTechStacks();
        if (techStacks != null) {
            User user = userRepository.findById(userdto.getUser_id()).get();
            techStacks.forEach(primarykey -> {
                UserTechStackMapId userTechStackMapId = new UserTechStackMapId(userdto.getUser_id(), primarykey);
                UserTechStack userTechStack = new UserTechStack();
                userTechStack.setUserTechStackMapId(userTechStackMapId);
                user.getTechStacks().add(userTechStack);
            });
            userRepository.save(user);
        }
    }

}