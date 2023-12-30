package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.UserDetails;

import java.util.Set;

@Data
public class CountryDto {

    private Long countryId;

    private String countryName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<UserDetails> userDetails;
}
