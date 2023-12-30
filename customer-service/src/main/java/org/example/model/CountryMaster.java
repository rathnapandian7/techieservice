package org.example.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cont_mstr")
@Setter
@Getter
public class CountryMaster {

    @Id
    @GeneratedValue(generator = "CONT_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "CONT_MSTR_GEN", sequenceName = "CONT_MSTR_SEQUENCE", initialValue = 50000, allocationSize = 1)
    @Column(name = "CONT_ID")
    private Long countryId;

    @Column(name = "CONT_NAME",unique=true,nullable = false)
    private String countryName;

    @OneToMany(mappedBy = "countryMaster",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference("country")
    private Set<UserDetails> userDetails;

}
