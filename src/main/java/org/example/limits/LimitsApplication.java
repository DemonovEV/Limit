package org.example.limits;

import org.example.limits.entity.ClientLimit;
import org.example.limits.entity.CommonLimit;
import org.example.limits.repository.ClientLimitRepository;
import org.example.limits.repository.CommonLimitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LimitsApplication {


    public static void main(String[] args) {
        var ctx = SpringApplication.run(LimitsApplication.class, args);

        var clientLimitRepository = ctx.getBean(ClientLimitRepository.class);
        var commonLimitRepository = ctx.getBean(CommonLimitRepository.class);


        var commonLimit = CommonLimit.builder()

                .clientType("LIMIT1")
                .amount(123456)
                .build();
        commonLimitRepository.save(commonLimit);

        var clientLimit = ClientLimit.builder()
                .amount(11111)
                .clientId("OOO MAJAK")
                .commonLimit(commonLimit)
                .build();


        clientLimitRepository.save(clientLimit);
        //  commonLimit.setAmount(66666);
        clientLimitRepository.save(clientLimit
                .toBuilder()
                .id(null)
                        .amount(222222)
                .clientId("ROGAKOPITA")
                .build());
        // clientLimit.setId(null);

    }

}
