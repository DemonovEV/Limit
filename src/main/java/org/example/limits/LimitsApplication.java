package org.example.limits;

import org.example.limits.entity.CommonLimit;
import org.example.limits.repository.CommonLimitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LimitsApplication {


    public static void main(String[] args) {
        var ctx = SpringApplication.run(LimitsApplication.class, args);
      //  var rep = ctx.getBean(CommonLimitRepository.class);
/*
        var cl = CommonLimit.builder()
                .clientType("REQ")
                .Amount(5000)
                .build();*/
       // rep.save(cl);


    }

}
