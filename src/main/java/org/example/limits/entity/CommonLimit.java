package org.example.limits.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.time.LocalDateTime;

@Data
@Entity(name = "common_limits")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder // TODO на время проектирования
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CommonLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String clientType;

    @Builder.Default
    @NonNull
    LocalDateTime dateBegin = LocalDateTime.now();

    @NonFinal
    LocalDateTime dateEnd;

    @NonNull
    float amount;
}
