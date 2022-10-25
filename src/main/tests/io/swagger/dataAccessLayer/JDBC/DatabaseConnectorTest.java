package io.swagger.dataAccessLayer.JDBC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectorTest {

    @Test
    void connect() {
        DatabaseConnector connector= new DatabaseConnector();
        assertDoesNotThrow(() -> connector.connect());
    }
}