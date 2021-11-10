package com.eggplant.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
        log.info("*----------------*");
        log.info("|                |");
        log.info("|   SUCCESS !!!  |");
        log.info("|                |");
        log.info("*----------------*");
    }
}
