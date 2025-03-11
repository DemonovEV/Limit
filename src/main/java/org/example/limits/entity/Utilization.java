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
@Entity(name = "utilization")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder // TODO на время проектирования
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor

public class Utilization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    UUID doc_id;
    @NonNull
    LocalDateTime date_hold;
    @NonNull
    float doc_amount;
    @NonNull
    String currency;
    @NonNull
    float utilization_amount;
    @NonNull
    boolean income;
    @NonFinal
    LocalDateTime date_proc;

    @NonFinal
    @Builder.Default
    @Enumerated(EnumType.STRING)
    UtilizationState state = UtilizationState.HOLD;

    @Builder.Default
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "limit_to_utilization",
            joinColumns =
            @JoinColumn(name = "utilization_ref", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "client_limit_ref", referencedColumnName = "id")

    )

    @NonFinal
    List<ClientLimit> clientLimitList = new ArrayList<>();
}