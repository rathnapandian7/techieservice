package org.example.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pin_mstr")
@Getter
@Setter
public class PinMaster {


    @Id
    @GeneratedValue(generator = "PIN_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "PIN_MSTR_GEN", sequenceName = "PIN_MSTR_SEQUENCE", initialValue = 10000, allocationSize = 1)
    @Column(name = "PN_CD_ID")
    private Long pinId;

    @Column(name = "PN_NAME",nullable = false,unique=true)
    private String pinName;
    @Column(name = "CITY_ID",nullable = false)
    private String cityId;


    @OneToMany(mappedBy = "pinMaster",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference("pinMstr")
    private Set<ZoneMaster> zoneMaster;
}
