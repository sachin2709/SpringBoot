package com.blueyonder.loggingdemo_easy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class    LoggingDemoEasyApplication {

    public static void main(String[] args) {


        SpringApplication.run(LoggingDemoEasyApplication.class, args);

        log.info("Info level");
        log.error("Error level");

    }

}
