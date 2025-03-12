package org.example.limits;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.limits.entity.*;
import org.example.limits.entity.enums.UtilizationState;
import org.example.limits.repository.ClientLimitRepository;
import org.example.limits.repository.CommonLimitRepository;
import org.example.limits.repository.CurrencyRepository;
import org.example.limits.repository.UtilizationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class LimitsApplication {


    public static void main(String[] args) {
        var ctx = SpringApplication.run(LimitsApplication.class, args);

        var clientLimitRepository = ctx.getBean(ClientLimitRepository.class);
        var commonLimitRepository = ctx.getBean(CommonLimitRepository.class);
        var utilizationRepository = ctx.getBean(UtilizationRepository.class);
        var currencyRepository = ctx.getBean(CurrencyRepository.class);

        System.out.println("Вот такие валюты у нас есть : ");
        System.out.println(
                currencyRepository.findAll()
        );


        // INIT COMMON LIMIT
        var commonLimit = CommonLimit.builder()
                .clientType("COMMON LIMIT 1")
                .amount(1000)
                .build();
        commonLimitRepository.save(commonLimit);
// MAKE PERSONAL LIMIT FOR CLIENT
        var clientPersonalLimit = Limit.builder()
                .clientId("ORG 1" )
                .amount(3000)
                .dateBegin(LocalDateTime.now())
                .dateEnd(LocalDateTime.now().plusDays(100))
                .build();

        clientLimitRepository.save(clientPersonalLimit);

// COPY COMMON LIMIT FOR CLIENT
        var clientCommonLimit = Limit.builder()
                .clientId(clientPersonalLimit.getClientId())
                .dateBegin(commonLimit.getDateBegin())
                .dateEnd(commonLimit.getDateEnd())
                .amount(commonLimit.getAmount())
                .used(0)
                .commonLimit(commonLimit)
                .build();
        clientLimitRepository.save(clientCommonLimit);
// Utilization 500
        var util1 =
                UtilizationDoc.builder()
                        .doc_id(UUID.randomUUID())
                        .date_hold(LocalDateTime.now())
                        .income(true)
                        .utilization_amount(500)
                        .doc_amount(500)
                        .date_proc(LocalDateTime.now())
                        .state(UtilizationState.PROCESSED)
                        .build();
        // Добавляю детали утилизации
        util1.getUtilizationItems().add(
                UtilizationItem.builder()
                        .limit(clientCommonLimit)
                        .amount(util1.getUtilization_amount())
                        .build());
        // Корректирую USED
        clientCommonLimit.setUsed(clientCommonLimit.getUsed()+util1.getUtilization_amount());

        utilizationRepository.save(util1);
        clientLimitRepository.save(clientCommonLimit);

// Utilization 800
        var util2 =
                UtilizationDoc.builder()
                        .doc_id(UUID.randomUUID())
                        .date_hold(LocalDateTime.now().plusHours(2))
                        .income(true)
                        .utilization_amount(800)
                        .doc_amount(800)
                        .date_proc(LocalDateTime.now())
                        .state(UtilizationState.PROCESSED)
                        .build();
// Добавляю детали утилизации - сначала по общему лимиту
        util2.getUtilizationItems().add(
                UtilizationItem.builder()
                        .limit(clientCommonLimit)
                        .amount(500)
                        .build());
        clientCommonLimit.setUsed(clientCommonLimit.getUsed()+500);

        util2.getUtilizationItems().add(
                UtilizationItem.builder()
                        .limit(clientPersonalLimit)
                        .amount(300)
                        .build());
        clientPersonalLimit.setUsed(clientPersonalLimit.getUsed()+ 300);

        utilizationRepository.save(util2);
        clientLimitRepository.save(clientCommonLimit);
        clientLimitRepository.save(clientPersonalLimit);


    }

}
