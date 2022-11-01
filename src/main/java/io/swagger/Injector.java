package io.swagger;
import io.swagger.configuration.jdbc.Configuration;
import io.swagger.configuration.jdbc.PropertyFactory;

public class Injector {

    public Injector() {

    }


    public static Configuration getConfig(String env) {
        return PropertyFactory.getConfiguration(env);
    }
}
