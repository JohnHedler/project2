package com.revature.developercorner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private Long id;
    private String message;
    private Long sender;
    private Long recipient;
    private String error_or_success;

}
