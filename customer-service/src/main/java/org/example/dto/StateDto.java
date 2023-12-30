package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.LocalMaster;

import java.util.Set;

@Data
public class StateDto {
    private Long stateId;

    private String stateName;
    private String countryId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<LocalMaster> localMaster;
}
