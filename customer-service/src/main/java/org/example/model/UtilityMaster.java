package org.example.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ulty_mstr")
@Data
public class UtilityMaster {

    @Id
    @GeneratedValue(generator = "ULTY_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ULTY_MSTR_GEN", sequenceName = "UTLY_MSTR_SEQUENCE", initialValue = 20000, allocationSize = 1)
    @Column(name = "ULTY_ID")
    private Long utilityId;

    @Column(name = "ULTY_NAME", nullable = false,unique=true)
    private String utilityName;

    @Column(name = "ULTY_IS_ACT",length = 1)
    private String isActive;

    @OneToMany(mappedBy = "utilityMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("utility")
    private Set<UserDetails> userDetail;

}
