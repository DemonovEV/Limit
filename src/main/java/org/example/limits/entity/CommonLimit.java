package org.example.limits.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name="common_limits")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
//@With
@NoArgsConstructor
@AllArgsConstructor
public class CommonLimit
        //  implements Persistable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    @NonNull
    String clientType;
    @Builder.Default
    @NonNull
    LocalDateTime dateBegin = LocalDateTime.now();
    LocalDateTime dateEnd;
    @NonNull
    float amount;
}
