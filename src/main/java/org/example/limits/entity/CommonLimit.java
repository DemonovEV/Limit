package org.example.limits.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("common_limits")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CommonLimit {
    @Id
    Long id;

    @NonNull
    String clientType;
    @Builder.Default
    @NonNull
    LocalDateTime dateBegin = LocalDateTime.now();
    LocalDateTime dateEnd;
    @NonNull
    float Amount;
}
