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

        var cl = CommonLimit.builder()
                .clientType("REQ")
                .Amount(5000)
                .build();

        var rep = ctx.getBean(CommonLimitRepository.class);

        rep.save(cl);

        var rep_cl_lim = ctx.getBean(ClientLimitRepository.class);

        rep_cl_lim.save(
                ClientLimit.builder()
                        .clientID("100500")
                        .commonLimit(cl)
                        .build()

        );

    }

}
