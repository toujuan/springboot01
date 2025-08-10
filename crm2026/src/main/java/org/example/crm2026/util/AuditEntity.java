package org.example.crm2026.util;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public abstract class AuditEntity {
    private String createdBy;
    private LocalDate createdTime;
    private String updatedBy;
    private LocalDate updatedTime;
}
