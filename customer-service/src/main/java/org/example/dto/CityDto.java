package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.LocalMaster;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CityDto {

    private Long cityId;

    private String cityName;

    private String stateId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<LocalMaster> localMaster;
}
