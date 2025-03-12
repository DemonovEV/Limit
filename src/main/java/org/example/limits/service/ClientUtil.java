package org.example.limits.service;

import lombok.AllArgsConstructor;
import org.example.limits.entity.Limit;
import org.example.limits.repository.ClientLimitRepository;
import org.example.limits.repository.CommonLimitRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ClientUtil {
    private final ClientLimitRepository clientLimitRepository;
    private final CommonLimitRepository commonLimitRepository;

    String getClientType(String clientId) {
        //TODO
        return "TEST_TYPE_1";
    }

    List<Limit> GetClientLimits(String clientId, LocalDateTime onDate) {
        var limits = clientLimitRepository.findClientLimitsOnDate(clientId, onDate);

        if (CollectionUtils.isEmpty(limits))
            limits = new ArrayList<>();
        else if (limits.stream().anyMatch(Limit::isCommonLimit))
            return limits;

        var commonLimits = commonLimitRepository.findClientTypeLimitsOnDate(
                getClientType(clientId), onDate
        );

        if (!CollectionUtils.isEmpty(commonLimits)) {
            limits.addAll(
                    commonLimits.stream().map(commonLimit ->
                                    Limit.builder()
                                            .clientId(clientId)
                                            .amount(commonLimit.getAmount())
                                            .dateBegin(commonLimit.getDateBegin())
                                            .dateEnd(commonLimit.getDateEnd())
                                            .commonLimit(commonLimit)
                                            .build())
                            .toList()
            );
        }

        return limits;
    }

}
