package com.revature.developercorner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserTechStackMapId implements Serializable {

    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "tech_stack_id")
    private Long techStackId;
}
