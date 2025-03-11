package org.example.limits;

import org.example.limits.entity.ClientLimit;
import org.example.limits.entity.CommonLimit;
import org.example.limits.entity.Utilization;
import org.example.limits.entity.enums.UtilizationState;
import org.example.limits.repository.ClientLimitRepository;
import org.example.limits.repository.CommonLimitRepository;
import org.example.limits.repository.UtilizationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class LimitsApplication {


    public static void main(String[] args) {
        var ctx = SpringApplication.run(LimitsApplication.class, args);

        var clientLimitRepository = ctx.getBean(ClientLimitRepository.class);
        var commonLimitRepository = ctx.getBean(CommonLimitRepository.class);
        var utilizationRepository = ctx.getBean(UtilizationRepository.class);


        var commonLimit = CommonLimit.builder()

                .clientType("COMMON LIMIT 1")
                .amount(1000)
                .build();
        commonLimitRepository.save(commonLimit);
//-----------------------------
        var clientLimit1 = ClientLimit.builder()
                .clientId("OOO MAJAK")
                .dateBegin(commonLimit.getDateBegin())
                .dateEnd(commonLimit.getDateEnd())
                .amount(commonLimit.getAmount())
                .commonLimit(commonLimit)
                .build();
        clientLimitRepository.save(clientLimit1);

        var clientLimit2 = ClientLimit.builder()
                .clientId(clientLimit1.getClientId())
                .amount(3000)
                .dateBegin(LocalDateTime.now())
                .dateEnd(LocalDateTime.now().plusDays(100))

                .build();

        clientLimitRepository.save(clientLimit2);

        var util1 =
                Utilization.builder()
                        //.id(1L)
                        .doc_id(UUID.randomUUID())
                        .date_hold(LocalDateTime.now())
                        .income(true)
                        .utilization_amount(100)
                        .currency("USD")
                        .doc_amount(100)
                        .state(UtilizationState.PROCESSED)
                        .build();


        util1.getClientLimitList().add(clientLimit1);
        util1.getClientLimitList().add(clientLimit2);

        utilizationRepository.save(util1);

        var util2 =
                Utilization.builder()
                        //.id(1L)
                        .doc_id(UUID.randomUUID())
                        .date_hold(LocalDateTime.now())
                        .income(true)
                        .utilization_amount(100)
                        .currency("USD")
                        .doc_amount(100)
                        .build();
        util2.getClientLimitList().add(clientLimit1);
        util2.getClientLimitList().add(clientLimit2);

        var clientLimit3 = ClientLimit.builder()
                .clientId(clientLimit1.getClientId())
                .amount(3000)
                .dateBegin(LocalDateTime.now())
                .dateEnd(LocalDateTime.now().plusDays(100))
                .commonLimit(commonLimit)
                .build();


        clientLimitRepository.save(clientLimit3);

        util2.getClientLimitList().add(clientLimit3);

        utilizationRepository.save(util2);
var utils=
        utilizationRepository.findAll();

        utils.forEach(
                utilization ->
                        utilization.getClientLimitList().forEach(
                                System.out::println
                        )
        );

        System.out.println(utils);

    }

}
