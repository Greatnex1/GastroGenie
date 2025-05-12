package com.ai.gastrogenie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class GastroGenieApplication {

    public static void main(String[] args) {
        SpringApplication.run(GastroGenieApplication.class, args);
//        log.info("======AI FOOD RECIPE GENERATOR STARTED=======");
    }

}
