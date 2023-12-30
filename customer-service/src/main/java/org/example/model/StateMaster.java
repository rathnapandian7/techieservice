package org.example.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stat_mstr")
@Setter
@Getter
public class StateMaster {

    @Id
    @GeneratedValue(generator = "STAT_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "STAT_MSTR_GEN", sequenceName = "STAT_MSTR_SEQUENCE", initialValue = 90000, allocationSize = 1)
    @Column(name = "STAT_ID")
    private Long stateId;

    @Column(name = "STAT_NAME",nullable = false,unique=true)
    private String stateName;
    @Column(name = "CONT_ID",nullable = false)
    private String countryId;


    @OneToMany(mappedBy = "stateMaster",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference("localmstr1")
    private Set<LocalMaster> localMaster;
}
