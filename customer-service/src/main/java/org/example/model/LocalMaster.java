package org.example.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "loc_mstr")
@Setter
@Getter
public class LocalMaster {

    @Id
    @GeneratedValue(generator = "LOCAL_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "LOCAL_MSTR_GEN", sequenceName = "LOCAL_MSTR_SEQUENCE", initialValue = 40000, allocationSize = 1)
    @Column(name = "LOC_ID")
    private Long localId;

    @Column(name = "LOC_NAME", nullable = false,unique=true)
    private String localName;

    @Column(name = "CUST_ID", nullable = false)
    private String customerId;

    @Column(name = "CITY_ID", nullable = false)
    private String cityId;

    @Column(name = "STAT_ID", nullable = false)
    private String stateId;

    @Column(name = "PN_CD_ID", nullable = false)
    private String pinCodeId;

    @Column(name = "LOC_IS_ACT",length = 1)
    private String isActive;


    @Column(name = "LOC_STUS")
    private String status;

    @Column(name = "ULTY_ID", nullable = false)
    private Long utilityId;

    @OneToMany(mappedBy = "localMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("localMstr")
    private Set<UserDetails> userDetails;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("cityMstr")
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID", insertable = false, updatable = false)
    private CityMaster cityMaster;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("localmstr1")
    @JoinColumn(name = "STAT_ID", referencedColumnName = "STAT_ID", insertable = false, updatable = false)
    private StateMaster stateMaster;


}
