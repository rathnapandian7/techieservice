package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.UserDetails;

import java.util.Set;

@Data
public class LocalDto {

    private Long localId;

    private String localName;

    private String customerId;

    private String cityId;

    private String stateId;

    private String pinCodeId;

    private String isActive;


    private String status;

    private Long utilityId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<UserDetails> userDetails;


}
