package org.example.limits.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("personal_limits")
public class PersonalLimit {

    private String inn;
    private LocalDateTime dateBegin;
    private LocalDateTime dateEnd;
    private float Amount;
}
