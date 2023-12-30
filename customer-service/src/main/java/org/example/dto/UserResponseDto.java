package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.UserDetails;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto {

    private Long customerId;
    private String customerName;

    private Set<UserDetails> userDetails;


}
