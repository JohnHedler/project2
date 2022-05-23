package com.revature.developercorner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class BlogDto {
    private Long id;
    private String title;
    private String content;
    private Integer upVotes;
    private Integer downVotes;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Long user_id;
    private String error_or_success;
}
