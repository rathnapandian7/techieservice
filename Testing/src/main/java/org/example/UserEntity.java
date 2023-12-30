package org.example;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "USER")
@Data
public class UserEntity {

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

    @Column(name = "CREATED_BY")
    private Integer creadtedBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime creadtedDate;

    @Column(name = "LAST_LOGGED_IN")
    private LocalDateTime lastLoggedIn;


    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

}
