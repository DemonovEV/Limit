package org.example.limits.entity;

import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("common_limits")
@Accessors(chain = true)

public class CommonLimit {

    @Id
            Long id;

    String clientType;
    LocalDateTime dateBegin;
    LocalDateTime dateEnd;
    float Amount;
}
