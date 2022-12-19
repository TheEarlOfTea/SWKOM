package at.fhtw3.swen3;
import at.fhtw3.swen3.configuration.jdbc.Configuration;
import at.fhtw3.swen3.configuration.jdbc.PropertyFactory;

public class Injector {

    public Injector() {

    }


    public static Configuration getConfig(String env) {
        return PropertyFactory.getConfiguration(env);
    }
}
