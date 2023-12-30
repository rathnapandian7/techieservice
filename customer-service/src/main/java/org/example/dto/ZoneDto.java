package org.example.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.PinMaster;
import org.example.model.UserDetails;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ZoneDto {
    private Long zoneId;

    private String zoneName;

    private String customerId;

    private String cityId;

    private String stateId;

    private String countryId;

    private String pinCodeId;

    private String isActive;

    private Set<UserDetails> userDetails;

    private PinMaster pinMaster;

}
