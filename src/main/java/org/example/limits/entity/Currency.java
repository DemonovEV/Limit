package org.example.limits.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.ToString;

@ToString
@Entity(name = "unfriendly_currencies")
public class Currency {
    @Id
    String value;
}
