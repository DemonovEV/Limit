package org.example.limits.repository;

import org.example.limits.entity.UtilizationItem;
import org.springframework.data.repository.CrudRepository;

public interface ItemUtizationRepositiry extends CrudRepository<UtilizationItem, Long> {
}
