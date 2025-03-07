package org.example.limits.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("common_limits")
public class CommonLimit {
    @Id
    private Long id;

    private String clientType;
    private LocalDateTime dateBegin;
    private LocalDateTime dateEnd;
    private float Amount;
}
