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

        var commonLimit = CommonLimit.builder()
                .clientType("REQ")
                .Amount(5000)
                .build();

        var rep = ctx.getBean(CommonLimitRepository.class);

       //  rep.save(commonLimit);
        //   rep.delete(commonLimit);
        // commonLimit.setAmount(55555);
        //commonLimit.setId(null);
        //   rep.save(commonLimit);

        var rep_cl_lim = ctx.getBean(ClientLimitRepository.class);
        var clientLimit = ClientLimit.builder()
                .clientID("100500")
                .commonLimit(commonLimit)
                .build();
        rep_cl_lim.save(
                clientLimit

        );



    }

}
