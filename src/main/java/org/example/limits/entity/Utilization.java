package org.example.limits.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.example.limits.entity.enums.UtilizationState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder // TODO на время проектирования
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Utilization {
    @Id
     Long id;

     UUID doc_id;
    LocalDateTime date_hold;
    float doc_amount;
    String currency;
    float utilization_amount;
    boolean income;
    LocalDateTime date_proc;

    @NonFinal
     UtilizationState state = UtilizationState.HOLD;
}