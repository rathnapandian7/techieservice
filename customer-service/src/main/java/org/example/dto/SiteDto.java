package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.example.model.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class SiteDto {

    private Long siteId;

    private String siteName;

    private String description;

    private String log;

    private String emailId;

    private String phoneNumber;

    private String mobNumber;

    private String addId;

    private String contCode;
    private String customerId;
    private String utilityId;
    private String zoneId;
    private String localId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<UserDetails> userDetails;
}
