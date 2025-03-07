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
        var clientLimit = ClientLimit.builder()
                .clientID("100500")
                // .commonLimit(commonLimit)
                .build();

        var commonLimit = CommonLimit.builder()
                .clientType("REQ")
                .Amount(5000)
                //  .clientLimit(new S<>())
                .build();

        commonLimit.getClientLimit().add(clientLimit);

        var clientLimit1 = clientLimit.withId(null);
        commonLimit.getClientLimit().add(clientLimit1.withAmount(54654));

        var clientLimit2 = clientLimit.withId(null).withAmount(1);
        commonLimit.getClientLimit().add(clientLimit2);

        var commonLimitRepository = ctx.getBean(CommonLimitRepository.class);
        var clientLimitRepository = ctx.getBean(ClientLimitRepository.class);


        commonLimitRepository.save(commonLimit);
        commonLimit.getClientLimit().add(clientLimit2.withId(null).withClientID("aadasd"));
        commonLimitRepository.save(commonLimit);/*
s.setAmount(111111);
        commonLimit.setAmount(2222222);
        commonLimit.getClientLimit().clear();
        commonLimit.getClientLimit().add(s);
        commonLimit.getClientLimit().add(s2);
        commonLimitRepository.save(commonLimit);
*/

    }

}
