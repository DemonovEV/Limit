package org.example.limits;

import org.example.limits.entity.CommonLimit;
import org.example.limits.entity.Limit;
import org.example.limits.entity.UtilizationDoc;
import org.example.limits.entity.UtilizationItem;
import org.example.limits.entity.enums.UtilizationState;
import org.example.limits.repository.ClientLimitRepository;
import org.example.limits.repository.CommonLimitRepository;
import org.example.limits.repository.CurrencyRepository;
import org.example.limits.repository.UtilizationRepository;
import org.example.limits.service.ClientUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
public class LimitsApplication {
    static public String CONST_FOR_TEST_TODO_DELETE="COMMON LIMIT 1";

    static CommonLimitRepository commonLimitRepository;
    static ClientLimitRepository clientLimitRepository;
    static UtilizationRepository utilizationRepository;
    static CurrencyRepository currencyRepository;
    static ClientUtil clientUtil;

    static void Test1() {
        var data = new ArrayList<CommonLimit>();

        var time = LocalDateTime.now()
                .withDayOfMonth(1)
                .truncatedTo(ChronoUnit.DAYS);
        for (int j = 0; j < 10; j++) {


            for (int i = -10; i < 5; i++) {
                data.add(
                        CommonLimit.builder()
                                .clientType("TEST " + Integer.toBinaryString(j))
                                .amount(Math.abs(i * j) * 100)
                                .dateBegin(time.plusMonths(i))
                                .dateEnd(time.plusMonths(i + 1).minusSeconds(1))
                                .build()
                );
            }
        }

        commonLimitRepository.saveAll(data);
//-------


        // INIT COMMON LIMIT
        var commonLimit = CommonLimit.builder()
                .clientType(CONST_FOR_TEST_TODO_DELETE)
                .amount(1000)
                .build();
        commonLimitRepository.save(commonLimit);
// MAKE PERSONAL LIMIT FOR CLIENT
        var clientPersonalLimit = Limit.builder()
                .clientId("ORG 1")
                .amount(3000)
                .dateBegin(LocalDateTime.now())
                .dateEnd(LocalDateTime.now().plusDays(100))
                .build();

        clientLimitRepository.save(clientPersonalLimit);
/*

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
*/
        clientUtil.GetClientLimits(clientPersonalLimit.getClientId(),LocalDateTime.now());
        clientUtil.GetClientLimits(clientPersonalLimit.getClientId(),LocalDateTime.now());

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
        clientCommonLimit.setUsed(clientCommonLimit.getUsed() + util1.getUtilization_amount());

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
        clientCommonLimit.setUsed(clientCommonLimit.getUsed() + 500);

        util2.getUtilizationItems().add(
                UtilizationItem.builder()
                        .limit(clientPersonalLimit)
                        .amount(300)
                        .build());
        clientPersonalLimit.setUsed(clientPersonalLimit.getUsed() + 300);

        utilizationRepository.save(util2);
        clientLimitRepository.save(clientCommonLimit);
        clientLimitRepository.save(clientPersonalLimit);
    }

    public static void main(String[] args) {
        var ctx = SpringApplication.run(LimitsApplication.class, args);

        clientLimitRepository = ctx.getBean(ClientLimitRepository.class);
        commonLimitRepository = ctx.getBean(CommonLimitRepository.class);
        utilizationRepository = ctx.getBean(UtilizationRepository.class);
        currencyRepository = ctx.getBean(CurrencyRepository.class);
        clientUtil = ctx.getBean(ClientUtil.class);

        System.out.println("Вот такие валюты у нас есть : ");
        System.out.println(
                currencyRepository.findAll()
        );
        Test1();
        var s = commonLimitRepository.findClientTypeLimitsOnDate("Asd", LocalDateTime.now());

        System.out.println(s.size());


    }

}
