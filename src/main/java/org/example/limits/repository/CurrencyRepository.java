package org.example.limits.repository;

import org.example.limits.entity.Currency;
import org.example.limits.entity.Limit;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface CurrencyRepository
        extends ListCrudRepository<Currency, String> {
}
