package org.customer.service.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "USER")
@Data
public class UserEntity extends UserAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "LAST_LOGGED_IN")
    private LocalDateTime lastLoggedIn;


}
