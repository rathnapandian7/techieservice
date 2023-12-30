package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.ZoneMaster;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PinDto {
    private Long pinId;
    private String pinName;
    private String cityId;
    private Set<ZoneMaster> zoneMaster;
}
