package org.example.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.UserDetails;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UtilityResponseDto {

    private String utilityName;

    private String isActive;
    private Set<UserDetails> userDetail;
}
