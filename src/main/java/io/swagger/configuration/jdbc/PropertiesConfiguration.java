package io.swagger.configuration.jdbc;


import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesConfiguration implements Configuration {

    private Properties appProperties;

    public PropertiesConfiguration(String fileName) {
        try {
            init(fileName);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void init(String fileName) throws IOException {
        URL appConfigPath = getClass().getClassLoader().getResource(fileName);
        appProperties = new Properties();
        appProperties.load(appConfigPath.openStream());

    }

    public String get(String key) {
        if (!appProperties.containsKey(key)) {
            throw new RuntimeException(key + "does not exist in properties");
        }
        return appProperties.getProperty(key);
    }
}
