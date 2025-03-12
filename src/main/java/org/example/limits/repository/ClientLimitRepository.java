package org.example.limits.repository;

import org.example.limits.entity.Limit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ClientLimitRepository
        extends CrudRepository<Limit, Long> {

    @Query("""
            select a from  client_limits a where
                a.clientId=:clientId
                    and
                a.dateBegin<=:onDate and :onDate<COALESCE(a.dateEnd,DATE_ADD(:onDate,'1 SECOND'))
            """)
    List<Limit> findClientLimitsOnDate(String clientId, LocalDateTime onDate);

}
