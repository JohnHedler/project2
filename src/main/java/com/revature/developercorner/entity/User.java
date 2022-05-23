package com.revature.developercorner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

//Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    //could use @Column(unique = true) to make this unique
    private String username;
    private String eMail;
    private String password;
    private String user_type;
    private Date availableTime;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<UserTechStack> techStacks = new HashSet<UserTechStack>(0);

    //Constructor without ID:
    public User(String username, String eMail, String password) {
        this.username = username;
        this.eMail = eMail;
        this.password = password;
    }
}
