package org.example.limits.repository;

import org.example.limits.entity.LimitUtilization;
import org.springframework.data.repository.CrudRepository;

public interface LimitUtilizationRepository extends CrudRepository<LimitUtilization, Integer> {
}
