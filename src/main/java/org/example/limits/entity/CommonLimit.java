package org.example.limits.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class CommonLimit {

String clientType;
    LocalDateTime dateBegin;
    LocalDateTime dateEnd;
    float Amount;
}
