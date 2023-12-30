package org.example.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.UserDetails;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RoleResponseDto {

    private Long roleId;

    private String roleType;

    private Set<UserDetails> userDetails;

}
