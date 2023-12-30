package org.customer.service.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TOKEN_DETAIL")
public class TokenDetailEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TOKEN_ID")
    private Integer tokenId;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "IS_REMEMBER")
    private Integer isRemember;

    @Column(name = "DEVICE_TYPE")
    private String devicetype;

    @Column(name = "CLIENT_IP")
    private String clientIp;

    @Column(name = "TOKEN_EXPIRY_TIME")
    private LocalDateTime tokenExpiryTime;

    @Column(name = "CREATED_BY")
    private String creadtedBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime creadtedDate;


    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;


}
