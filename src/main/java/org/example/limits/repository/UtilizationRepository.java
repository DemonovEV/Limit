package org.example.limits.repository;

import org.example.limits.entity.UtilizationDoc;
import org.springframework.data.repository.CrudRepository;

public interface UtilizationRepository extends CrudRepository<UtilizationDoc, Long> {
}