package org.example.limits;

import org.example.limits.entity.Utilization;
import org.example.limits.repository.CommonLimitRepository;
import org.example.limits.repository.LimitUtilizationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class LimitsApplication {


    public static void main(String[] args) {
        var ctx = SpringApplication.run(LimitsApplication.class, args);
        var rep = ctx.getBean(CommonLimitRepository.class);
      /*  System.out.println(rep);

        rep.findAll()
                .forEach(System.out::println);

        var utils = ctx.getBean(LimitUtilizationRepository.class);

        System.out.println(utils);
       // @org.springframework.data.convert.ValueConverter(org.springframework.data.convert.PropertyValueConverter.ObjectToObjectPropertyValueConverter.class)org.example.limits.entity.enums.UtilizationState
     //   org.example.limits.entity.LimitUtilization.state
        Utilization obj = new Utilization("111111111",
                UUID.randomUUID(),
                LocalDateTime.now(),
                100,
                "EUR",
                80,
                true

                );

        utils.save(obj);
        obj = new Utilization("111111111",
                UUID.randomUUID(),
                LocalDateTime.now(),
                100,
                "EUR",
                80,
                true

        );

        *//*utils.save(obj.withId(null));
        utils.save(obj.withId(null));
        utils.save(obj.withId(null));
*//*

        */
    }

}
