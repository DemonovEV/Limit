package org.example.limits;

import org.example.limits.entity.CommonLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.example.limits.repository.CommonLimitRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class LimitsApplication {



    public static void main(String[] args) {
        var ctx=SpringApplication.run(LimitsApplication.class, args);
        var rep=ctx.getBean(CommonLimitRepository.class);
        System.out.println(rep);

        rep.findAll()
                .forEach(System.out::println);
/*var s=
        rep.findAll();
s
                .forEach(commonLimit -> commonLimit.setAmount(12345));

       // rep.saveAll(s);
        s.forEach(
                rep::save

        );
        rep.save(new CommonLimit()
                        .setClientType("test")
                .setAmount(123)
                        .setDateBegin(LocalDateTime.now())
               // ;
        );*/
    }

}
