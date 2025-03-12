package org.example.limits.repository;

import org.example.limits.entity.CommonLimit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CommonLimitRepository
        extends CrudRepository<CommonLimit, Long> {

    @Query("""
            select a from  common_limits a where
                a.clientType=:clientType
                    and
                a.dateBegin<=:onDate and :onDate<COALESCE(a.dateEnd,DATE_ADD(:onDate,'1 SECOND'))
            """)
    List<CommonLimit> findClientTypeLimitsOnDate(String clientType, LocalDateTime onDate);


}
