package org.example.limits.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("common_limits")
public class CommonLimit {

    String clientType;
    LocalDateTime dateBegin;
    LocalDateTime dateEnd;
    float Amount;
}
