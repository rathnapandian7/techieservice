package org.example.repository;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInformation {

    private Integer userId;

    private String firstName;

    private String lastName;

    private String userName;

    private Integer creadtedBy;

    private String token;

    private String refreshToken;

    private LocalDateTime creadtedDate;

    private LocalDateTime lastLoggedIn;

    private Integer updatedBy;

    private LocalDateTime updatedDate;
}
