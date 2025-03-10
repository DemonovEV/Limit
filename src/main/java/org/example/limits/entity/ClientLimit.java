package org.example.limits.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity(name = "client_limits")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
//@With
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
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
    LocalDateTime dateEnd;
    @NonNull
    float amount;

    @Builder.Default
    float used = 0;
    @Builder.Default
    float hold = 0;


    // @Column("common_limit_ref")
    /// @MappedCollection(idColumn ="id123",keyColumn = "common_limit_ref123")


    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "common_limit_ref", referencedColumnName="id")
    CommonLimit commonLimit;
}
