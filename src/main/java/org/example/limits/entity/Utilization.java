package org.example.limits.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.limits.entity.enums.UtilizationState;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table

@AllArgsConstructor
@RequiredArgsConstructor
public class Utilization {
    @Id
    private Long id;

    private final String clientID;
    private final UUID doc_id;
    private final LocalDateTime date_hold;
    private final float doc_amount;
    private final String currency;
    private final float utilization_amount;
    private final boolean income;
    LocalDateTime date_proc;

    private UtilizationState state = UtilizationState.HOLD;
}