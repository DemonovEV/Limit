package org.example.limits;

import org.example.limits.entity.LimitUtilization;
import org.example.limits.repository.CommonLimitRepository;
import org.example.limits.repository.LimitUtilizationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LimitsApplication {


    public static void main(String[] args) {
        var ctx = SpringApplication.run(LimitsApplication.class, args);
        var rep = ctx.getBean(CommonLimitRepository.class);
        System.out.println(rep);

        rep.findAll()
                .forEach(System.out::println);

        var utils = ctx.getBean(LimitUtilizationRepository.class);

        System.out.println(utils);

        var o = new LimitUtilization

    }

}
