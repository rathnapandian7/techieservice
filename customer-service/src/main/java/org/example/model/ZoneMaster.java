package org.example.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "zone_mstr")
@Getter
@Setter
public class ZoneMaster {

    @Id
    @GeneratedValue(generator = "ZONE_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ZONE_MSTR_GEN", sequenceName = "ZONE_MSTR_SEQUENCE", initialValue = 60000, allocationSize = 1)
    @Column(name = "ZN_ID")
    private Long zoneId;

    @Column(name = "ZN_NAME", nullable = false, unique = true)
    private String zoneName;

    @Column(name = "CUST_ID", nullable = false)
    private String customerId;

    @Column(name = "CITY_ID", nullable = false)
    private String cityId;

    @Column(name = "STAT_ID", nullable = false)
    private String stateId;

    @Column(name = "CONT_ID", nullable = false)
    private String countryId;

    @Column(name = "PN_CD_ID", nullable = false)
    private String pinCodeId;

    @Column(name = "ZN_IS_ACT")
    private String isActive;

    @OneToMany(mappedBy = "zoneMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("zonemstr")
    private Set<UserDetails> userDetails;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("pinMstr")
    @JoinColumn(name = "PN_CD_ID", referencedColumnName = "PN_CD_ID", insertable = false, updatable = false)
    private PinMaster pinMaster;

}
