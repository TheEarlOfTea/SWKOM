package io.swagger.persistence.JDBC;

import io.swagger.Injector;
import io.swagger.configuration.jdbc.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnector {
    private Connection connection;
    private final String DB_URL;
    private final String DB_USER;
    private final String DB_PASSWORD;

    public DatabaseConnector() {
        Configuration conf = Injector.getConfig("application.properties");
        this.DB_URL = conf.get("db.dbLink");
        this.DB_USER = conf.get("db.user");
        this.DB_PASSWORD = conf.get("db.password");
    }

    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        //DatabaseSetup.setUp();
    }

    public Connection getConnection() {
        return connection;
    }
}