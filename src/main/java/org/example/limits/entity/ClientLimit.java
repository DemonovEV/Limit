package org.example.limits.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity(name = "client_limits")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true) // TODO на время проектирования
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ClientLimit {
    @Id
    //@GeneratedValue(generator = "client_limits_id_seq", strategy = GenerationType.SEQUENCE)
    //@SequenceGenerator(allocationSize = 1, name = "client_limits_id_seq")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    final Long id;

    @NonNull

    String clientId;
    @Builder.Default
    @NonNull
    final LocalDateTime dateBegin = LocalDateTime.now();
    LocalDateTime dateEnd;
    @NonNull
    final float amount;

    @Builder.Default
    float used = 0;
    @Builder.Default
    float hold = 0;


    // @Column("common_limit_ref")
    /// @MappedCollection(idColumn ="id123",keyColumn = "common_limit_ref123")


    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "common_limit_ref", referencedColumnName="id")
    final CommonLimit commonLimit;
}
