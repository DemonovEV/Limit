package org.example.limits.repository;

import org.example.limits.entity.PersonalLimit;
import org.springframework.data.repository.CrudRepository;

public interface PersonalLimitRepository
        extends CrudRepository<PersonalLimit, Void> {
}
