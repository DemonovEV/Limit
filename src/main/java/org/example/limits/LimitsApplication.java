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
                .amount(100)
                .build();

        var commonLimit = CommonLimit.builder()
                .clientType("REQ")
                .amount(5000)
                //  .clientLimit(new S<>())
                .build();


        commonLimit.getClientLimit().add(clientLimit);

        var clientLimit1 = clientLimit.withId(null).withAmount(101);
        commonLimit.getClientLimit().add(clientLimit1);


        var clientLimit2 = clientLimit1.withId(null).withAmount(100);
        commonLimit.getClientLimit().add(clientLimit2);

        System.out.println(clientLimit2);
        System.out.println(clientLimit2.hashCode());

        var commonLimitRepository = ctx.getBean(CommonLimitRepository.class);
        var clientLimitRepository = ctx.getBean(ClientLimitRepository.class);

        commonLimitRepository.save(commonLimit);
       // commonLimit.getClientLimit().add(clientLimit2.withId(null).withClientID("aadasd"));
        commonLimitRepository.save(commonLimit);

       // commonLimitRepository.delete(commonLimit);

        /*
s.setAmount(111111);
        commonLimit.setAmount(2222222);
        commonLimit.getClientLimit().clear();
        commonLimit.getClientLimit().add(s);
        commonLimit.getClientLimit().add(s2);
        commonLimitRepository.save(commonLimit);
*/

    }

}
