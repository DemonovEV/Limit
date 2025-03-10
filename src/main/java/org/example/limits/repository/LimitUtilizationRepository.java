package org.example.limits.repository;

import org.example.limits.entity.Utilization;
import org.springframework.data.repository.CrudRepository;

public interface LimitUtilizationRepository extends CrudRepository<Utilization, Long> {
}
