package org.example.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.UserDetails;

import java.util.Set;

@Data
public class UtilityDto {

    private Long utilityId;
    private String utilityName;

    private String isActive;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<UserDetails> userDetail;

}
