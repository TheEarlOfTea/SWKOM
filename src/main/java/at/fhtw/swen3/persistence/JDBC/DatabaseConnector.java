package at.fhtw.swen3.persistence.JDBC;

import at.fhtw.swen3.Injector;
import at.fhtw.swen3.configuration.jdbc.Configuration;

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
        this.DB_URL = System.getenv("db-url");
        this.DB_USER = System.getenv("db-username");
        this.DB_PASSWORD = System.getenv("db-password");
    }

    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }


}