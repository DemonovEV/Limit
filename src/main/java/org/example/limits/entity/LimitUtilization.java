package org.example.limits.entity;

import lombok.Data;
import org.example.limits.entity.enums.UtilizationState;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table
public class LimitUtilization {
    @Id
    private Long id;

    private final String inn;
    private final UUID doc_id;
    private final LocalDateTime date_hold;
    private final float doc_amount;
    private final String currency;
    private final float utilization_amount;
    private final boolean income;
    LocalDateTime date_proc;
    @Column("STATE")
    String getState()
    {return "asd";}
    private UtilizationState state =UtilizationState.HOLD;
}