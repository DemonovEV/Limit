package org.example.limits.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("client_limits")
public class ClientLimit {
    @Id
    private Long id;

    private String clientID;
    private LocalDateTime dateBegin;
    private LocalDateTime dateEnd;
    private float Amount;

    private CommonLimit commonLimit;

}
