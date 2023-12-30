package org.example.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CITY_MSTR")
@Getter
@Setter
public class CityMaster {


    @Id
    @GeneratedValue(generator = "CITY_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "CITY_MSTR_GEN", sequenceName = "CITY_MSTR_SEQUENCE", initialValue = 8000, allocationSize = 1)
    @Column(name = "CITY_ID")
    private Long cityId;

    @Column(name = "CITY_NAME",nullable = false,unique=true)
    private String cityName;

    @Column(name = "STAT_ID",nullable = false)
    private String stateId;


    @OneToMany(mappedBy = "cityMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("cityMstr")
    private Set<LocalMaster> localMaster;
}
