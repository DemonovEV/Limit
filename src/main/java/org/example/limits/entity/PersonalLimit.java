package org.example.limits.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("personal_limits")
public class PersonalLimit {

    String inn;
    LocalDateTime dateBegin;
    LocalDateTime dateEnd;
    float Amount;
}
