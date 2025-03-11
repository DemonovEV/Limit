package org.example.limits.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.time.LocalDateTime;

@Data
@Entity(name = "client_limits")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(toBuilder = true) // TODO на время проектирования
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ClientLimit {
    @Id
    //@GeneratedValue(generator = "client_limits_id_seq", strategy = GenerationType.SEQUENCE)
    //@SequenceGenerator(allocationSize = 1, name = "client_limits_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String clientId;

    @Builder.Default
    @NonNull
    LocalDateTime dateBegin = LocalDateTime.now();

    @NonFinal
    LocalDateTime dateEnd;

    @NonNull
    float amount;

    @Builder.Default
    @NonNull
    @NonFinal
    float used = 0;

    @Builder.Default
    @NonNull
    @NonFinal
    float hold = 0;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "common_limit_ref", referencedColumnName = "id")
    final CommonLimit commonLimit;
}
