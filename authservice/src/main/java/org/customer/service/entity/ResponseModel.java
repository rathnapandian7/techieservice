package org.customer.service.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseModel {

    private int status;
    private String message;

}
