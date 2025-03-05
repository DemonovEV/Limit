package org.example.limits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.example.limits.repository.CommonLimitRepository;

@SpringBootApplication
public class LimitsApplication {



    public static void main(String[] args) {
        var ctx=SpringApplication.run(LimitsApplication.class, args);
        var rep=ctx.getBean(CommonLimitRepository.class);
        System.out.println(rep);

        rep.findAll()
                .forEach(System.out::println);


    }

}
