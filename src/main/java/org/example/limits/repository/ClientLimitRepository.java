package org.example.limits.repository;

import org.example.limits.entity.ClientLimit;
import org.springframework.data.repository.CrudRepository;

public interface ClientLimitRepository
        extends CrudRepository<ClientLimit, Void> {
}
