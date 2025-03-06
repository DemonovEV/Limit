package org.example.limits.entity;

import lombok.Data;
import org.example.limits.entity.enums.UtilizationState;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table
public class LimitUtilization {
    final String inn;
    final UUID doc_id;
    final LocalDateTime date_hold;
    final float doc_amount;
    final String currency;
    final float utilization_amount;
    final boolean income;
    LocalDateTime date_proc;
    UtilizationState state;
}