package org.example.limits.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.example.limits.entity.enums.UtilizationState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "utilization_doc")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder // TODO на время проектирования
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UtilizationDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    UUID doc_id;
    @NonNull
    LocalDateTime date_hold;
    @NonNull
    float utilization_amount;
    @NonNull
    // @Builder.Default
    float doc_amount;// = utilization_amount;
    @NonNull
    @Builder.Default
    String currency = "USD";

    @NonNull
    boolean income;
    @Builder.Default


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilization_doc_ref", nullable = false)
    List<UtilizationItem> utilizationItems = new ArrayList<>();
    @NonFinal
    LocalDateTime date_proc;
    @NonFinal
    @Builder.Default
    @Enumerated(EnumType.STRING)
    UtilizationState state = UtilizationState.HOLD;

}