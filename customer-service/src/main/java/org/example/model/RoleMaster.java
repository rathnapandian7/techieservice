package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role_mstr")
@Getter
@Setter
public class RoleMaster {

    @Id
    @GeneratedValue(generator = "ROLE_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ROLE_MSTR_GEN", sequenceName = "ROLE_MSTR_SEQUENCE", initialValue = 30000, allocationSize = 1)
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "ROLE_TYP",nullable = false,unique=true)
    private String roleType;

    @OneToMany(mappedBy = "roleMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("role")
    private Set<UserDetails> userDetails;
}
