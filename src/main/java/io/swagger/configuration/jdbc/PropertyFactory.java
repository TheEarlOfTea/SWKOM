package io.swagger.configuration.jdbc;

public class PropertyFactory {


    public static Configuration getConfiguration(String env) {
        if (env.equals("application.properties")) {
            return new PropertiesConfiguration(env);
        }
        throw new RuntimeException(env + "Configuration not found");
    }
}
