package org.example.limits.repository;

import org.example.limits.entity.Limit;
import org.springframework.data.repository.CrudRepository;

public interface ClientLimitRepository
        extends CrudRepository<Limit, Long> {
}
