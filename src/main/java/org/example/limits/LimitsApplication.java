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
        var commonLimit= CommonLimit.builder()

                .clientType("Asd")
                .build();


      var clientLimit= ClientLimit.builder()
             // .id(100L)
              .amount(12313)
              .clientId("asd")
              .commonLimit(commonLimit)
              .build();

        var clientLimitRepository=ctx.getBean(ClientLimitRepository.class);
        var commonLimitRepository=ctx.getBean(CommonLimitRepository.class);

      //  commonLimitRepository.save(commonLimit);
        clientLimitRepository.save(clientLimit);
        commonLimit.setAmount(66666);
        clientLimitRepository.save(clientLimit);
       clientLimit.setId(null);

    }

}
