package org.example.limits.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("client_limits")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ClientLimit {
    @Id
    Long id;

    @NonNull
    String clientID;
    @Builder.Default
    @NonNull
    LocalDateTime dateBegin = LocalDateTime.now();
    LocalDateTime dateEnd;
    @NonNull
    float Amount;

    @Builder.Default
    float used = 0;
    @Builder.Default
    float hold = 0;

    @MappedCollection(idColumn ="CommonLimit",keyColumn = "id")
    CommonLimit commonLimit;
}
