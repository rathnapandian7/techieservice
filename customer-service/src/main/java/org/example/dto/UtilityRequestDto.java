package org.example.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;

@Data
public class UtilityRequestDto {


    private String utilityName;

    private String isActive;

}
