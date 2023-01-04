package at.fhtw.swen3.persistence.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseSetup {


    public static void setUp() throws SQLException {

        DatabaseConnector connector= new DatabaseConnector();
        connector.connect();
        Connection connection= connector.getConnection();

        try {
            PreparedStatement statement=connection.prepareStatement("alter table t_hops alter column region_geo_json type text using region_geo_json::text");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql error");
        }
        connection.close();
    }

}
