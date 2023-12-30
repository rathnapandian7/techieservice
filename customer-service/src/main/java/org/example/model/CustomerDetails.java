package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CUST_DTL")
@Getter
@Setter
public class CustomerDetails implements Serializable {

    @Id
    @GeneratedValue(generator = "CUST_DETL_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "CUST_DETL_GEN", sequenceName = "CUSTOMER_SEQUENCE", initialValue = 70000, allocationSize = 1)
    @Column(name = "CUST_ID")
    private Long customerId;
    @Column(name = "PREFIX_CUST_ID")
    private String prefixCUstomerId;

    @Column(name = "CUST_NAME", unique=true)
    private String customerName;

    @Column(name = "CUST_DESC")
    private String description;

    @Column(name = "ULTY_ID",nullable = false)
    private String utilityId;
    @Column(name = "CUST_PRFL_LOG")
    private String profileLog;
    @Column(name = "CUST_PYMT_TYP")
    private String paymentType;
    @Column(name = "CUST_EML_ID")
    private String mailId;
    @Column(name = "CUST_PH_NUM")
    private String phoneNumber;
    @Column(name = "CUST_MBL_NUM")
    private String mbleNumber;
    @Column(name = "CUST_ADD_ID")
    private String addId;
    @Column(name = "CUST_CONT_CODE")
    private String contactCode;
    @Column(name = "CUST_MOD_TYP")
    private String modType;
    @Column(name = "CUST_IS_ACT",length = 1)
    private String isActive;
    @Column(name = "CUST_STUS")
    private String status;


    @OneToMany(mappedBy = "customerDetailsModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<UserDetails> userDetails;


}

