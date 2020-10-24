package com.mydeveloperplanet.myspringcloudfunctionplanet;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class MySpringCloudFunctionPlanetApplication {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(MySpringCloudFunctionPlanetApplication.class, args);
    }

    @Bean
    public Function<String, Boolean> containsCloud() {
        return value -> value.contains("cloud");
    }

}
