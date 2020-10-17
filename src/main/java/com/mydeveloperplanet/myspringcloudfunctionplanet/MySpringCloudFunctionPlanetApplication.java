package com.mydeveloperplanet.myspringcloudfunctionplanet;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Function;

@SpringBootConfiguration
public class MySpringCloudFunctionPlanetApplication implements ApplicationContextInitializer<GenericApplicationContext> {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(MySpringCloudFunctionPlanetApplication.class, args);
    }

    public Function<String, Boolean> containsCloud() {
        return value -> value.contains("cloud");
    }

    @Override
    public void initialize(GenericApplicationContext context) {
        context.registerBean("containsCloud", FunctionRegistration.class,
                () -> new FunctionRegistration<>(containsCloud())
                        .type(FunctionType.from(String.class).to(Boolean.class)));
    }

}
