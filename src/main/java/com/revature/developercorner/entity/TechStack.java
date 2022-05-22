package com.revature.developercorner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "tech_stack")
public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stack;

    //Constructor without ID:
    public TechStack(String stack) {
        this.stack = stack;
    }
}
