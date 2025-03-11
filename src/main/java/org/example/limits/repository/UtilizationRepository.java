package org.example.limits.repository;

import org.example.limits.entity.Utilization;
import org.springframework.data.repository.CrudRepository;

public interface UtilizationRepository extends CrudRepository<Utilization, Long> {
}