package org.customer.service.entity;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Data
public class UserAudit {

    @Column(name = "CREATED_BY")
    private Integer creadtedBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime creadtedDate;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

}
