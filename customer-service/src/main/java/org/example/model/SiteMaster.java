package org.example.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "site_mstr")
@Getter
@Setter
public class SiteMaster {

    @Id
    @GeneratedValue(generator = "SITE_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SITE_MSTR_GEN", sequenceName = "SITE_MSTR_SEQUENCE", initialValue = 3000, allocationSize = 1)
    @Column(name = "SIT_ID")
    private Long siteId;

    @Column(name = "SIT_NAME", nullable = false,unique=true)
    private String siteName;

    @Column(name = "SIT_DESC")
    private String description;

    @Column(name = "SIT_LOG")
    private String log;

    @Column(name = "SIT_EML_ID")
    private String emailId;

    @Column(name = "SIT_PH_NUM")
    private String phoneNumber;

    @Column(name = "SIT_MBL_NUM")
    private String mobNumber;

    @Column(name = "ADD_ID")
    private String addId;

    @Column(name = "SIT_CONT_CODE")
    private String contCode;
    @Column(name = "CUST_ID", nullable = false)
    private String customerId;
    @Column(name = "ULTY_ID", nullable = false)
    private String utilityId;
    @Column(name = "ZN_ID", nullable = false)
    private String zoneId;
    @Column(name = "LOC_ID", nullable = false)
    private String localId;

    @OneToMany(mappedBy = "siteMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("siteMstr")
    private Set<UserDetails> userDetails;


}
