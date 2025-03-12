package org.example.limits.repository;

import org.example.limits.entity.Currency;
import org.springframework.data.repository.ListCrudRepository;

public interface CurrencyRepository
        extends ListCrudRepository<Currency, String> {
}
