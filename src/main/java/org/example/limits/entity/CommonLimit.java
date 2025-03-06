package org.example.limits.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("common_limits")
public class CommonLimit {

    private String clientType;
    private LocalDateTime dateBegin;
    private LocalDateTime dateEnd;
    private float Amount;
}
