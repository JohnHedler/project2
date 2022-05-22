package com.revature.developercorner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Long id;
    private Long user_id;
    private String language;
    private String question;
    private Date created_at;
    private Date updated_at;
    private String error_or_success;

}


