package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.model.UserDetails;

import java.util.Set;

@Data
public class RoleDto {

    private Long roleId;

    private String roleType;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<UserDetails> userDetails;


}
