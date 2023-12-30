package org.example.dto;


import lombok.Data;

@Data
public class CustomerResponseDto {

    private Long customerId;
    private String customerName;
    private String description;
    private String utilityId;
    private String profileLog;
    private String paymentType;
    private String mailId;
    private String phoneNumber;
    private String mbleNumber;
    private String addId;
    private String contactCode;
    private String modType;
    private String isActive;
    private String status;
}
