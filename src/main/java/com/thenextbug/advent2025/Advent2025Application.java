package com.thenextbug.advent2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Advent2025Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Advent2025Application.class).web(WebApplicationType.NONE).run(args);
    }

}
