package com.revature.developercorner.controller;

import com.revature.developercorner.dto.UserDto;
import com.revature.developercorner.entity.User;
import com.revature.developercorner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public boolean login(@RequestBody UserDto userDto) {
        System.out.println(userDto);

        User user = new User();
        user.setUser_id(userDto.getUser_id());
        user.setPassword(userDto.getPassword());

        return true;
    }

    @PostMapping("/adduser")
    public UserDto addUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        User user = new User();
        user.setUsername(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setEMail(userDto.getEmail());
        user.setUser_type(userDto.getUser_type());

        if (userDto.getAvailableTime() != null)
            user.setAvailableTime(new Date(userDto.getAvailableTime().getTime()));

        user = userService.addUser(user);

        userDto.setUser_id(user.getUser_id());
        userDto.setError_or_success("SUCCESS");
        System.out.println(user);
        return userDto;
    }

    @PostMapping("/updateuser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        User user = new User();
        user.setUser_id(userDto.getUser_id());
        user.setUsername(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setEMail(userDto.getEmail());
        userService.update_user(user, user.getUser_id());

        System.out.println(user);
        userDto.setError_or_success("SUCCESS");
        return userDto;
    }


    @PostMapping("/deleteuser")
    public UserDto deleteUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        userService.delete(userDto.getUser_id());
        userDto.setError_or_success("SUCCESS");
        return userDto;

    }

    @PostMapping("/updateuseravailabletime")
    public UserDto updateUserTime(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        User user = new User();
        user.setUser_id(userDto.getUser_id());
        user.setAvailableTime(new Date(userDto.getAvailableTime().getTime()));
        userService.update_user(user, user.getUser_id());

        System.out.println(user);
        userDto.setError_or_success("SUCCESS");
        return userDto;
    }

    @GetMapping("/listusers")
    public List listusers(@RequestBody UserDto userDto) {
        List<User> users = userService.getAll();
        List userDtolist = new ArrayList();

        if (users != null) {
            users.forEach(user -> {
                UserDto userDto1 = new UserDto();
                userDto1.setUser_id(user.getUser_id());
                userDto1.setUserName(user.getUsername());
                userDto1.setEmail(user.getEMail());
                userDto1.setPassword(user.getPassword());
                userDto1.setUser_type(user.getUser_type());
                userDto1.setAvailableTime(user.getAvailableTime());
                userDtolist.add(userDto1);
            });
        }
        return userDtolist;
    }

    @PostMapping("/updateusertechstack")
    public UserDto saveUserTechStack(@RequestBody UserDto userdto) {
        System.out.println(userdto);
        userService.updateUserTechStack(userdto);
        userdto.setError_or_success("SUCCESS");
        return userdto;
    }

}

