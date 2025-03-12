package org.example.limits.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@Entity(name = "utilization_items")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UtilizationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "limit_ref", nullable = false)
    Limit limit;
    float amount;
}
