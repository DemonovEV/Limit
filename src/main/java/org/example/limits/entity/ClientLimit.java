package org.example.limits.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("client_limits")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@With
public class ClientLimit {
   private   Long getIdFortoBuilder() {
        return null;
    };

    @Id
    @Builder.ObtainVia(method = "getIdFortoBuilder")
    @With Long id;

    @NonNull
    String clientID;
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

}
