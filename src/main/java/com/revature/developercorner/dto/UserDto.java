package com.revature.developercorner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long user_id;
    private String userName;
    private String email;
    private String password;
    private String user_type;
    private Date availableTime;
    private String error_or_success;

    private List<Long> techStacks;
}
