package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER_DTL")
@Getter
@Setter
public class UserDetails {

    @Id
    @GeneratedValue(generator = "USER_DETL_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "USER_DETL_GEN", sequenceName = "USER_SEQUENCE", initialValue = 80000, allocationSize = 1)

    @Column(name = "USR_ID")
    private Long userId;

    @Column(name = "USR_NAME", unique = true)
    private String userName;

    @Column(name = "USR_PASWD")
    private String password;

    @Column(name = "PREFIX_USER_ID")
    private String prefixUserId;
    @Column(name = "USR_FST_NAME")
    private String firstName;

    @Column(name = "USR_MDL_NAME")
    private String middleName;

    @Column(name = "USR_LST_NAME")
    private String lastName;


    @Column(name = "USR_IS_ACT")
    private String isActive;

    @Column(name = "USR_PH_NUM")
    private String phoneNumber;

    @Column(name = "USR_MBL_NUM")
    private String mblNumber;
    @NotNull
    @Column(name = "CONT_ID")
    private String contCode;
    @NotNull
    @Column(name = "ZN_ID")
    private String zoneCodeId;
    @NotNull
    @Column(name = "LOC_ID")
    private String locId;

    @Column(name = "USR_EML_ID")
    private String mailId;
    @NotNull
    @Column(name = "CUST_ID_FK")
    private Long customerId;
    @NotNull
    @Column(name = "SIT_ID")
    private String sitId;
    @NotNull
    @Column(name = "ROLE_ID")
    private String roleId;

    @Column(name = "USR_STUS")
    private String status;
    @NotNull
    @Column(name = "ULTY_ID")
    private String utilityId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUST_ID_FK", referencedColumnName = "CUST_ID", insertable = false, updatable = false)
    @JsonBackReference
    private CustomerDetails customerDetailsModel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID", insertable = false, updatable = false)
    @JsonBackReference("role")
    private RoleMaster roleMaster;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ULTY_ID", referencedColumnName = "ULTY_ID", insertable = false, updatable = false)
    @JsonBackReference("utility")
    private UtilityMaster utilityMaster;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("siteMstr")
    @JoinColumn(name = "SIT_ID", referencedColumnName = "SIT_ID", insertable = false, updatable = false)
    private SiteMaster siteMaster;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("localMstr")
    @JoinColumn(name = "LOC_ID", referencedColumnName = "LOC_ID", insertable = false, updatable = false)
    private LocalMaster localMaster;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("zonemstr")
    @JoinColumn(name = "ZN_ID", referencedColumnName = "ZN_ID", insertable = false, updatable = false)
    private ZoneMaster zoneMaster;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("country")
    @JoinColumn(name = "CONT_ID", referencedColumnName = "CONT_ID", insertable = false, updatable = false)
    private CountryMaster countryMaster;


}