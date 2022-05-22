package com.revature.developercorner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "users_tech_stack")
public class UserTechStack {

    @EmbeddedId
    UserTechStackMapId userTechStackMapId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tech_stack_id", nullable = false, insertable = false, updatable = false)
    private TechStack techStack;
}
