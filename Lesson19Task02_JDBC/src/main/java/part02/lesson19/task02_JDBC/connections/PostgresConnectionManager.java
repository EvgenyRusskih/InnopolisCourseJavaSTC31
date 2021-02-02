package part02.lesson19.task02_JDBC.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionManager implements ConnectionManager {

    /**
     * JDBC connection parameters
     */
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "postgres";
    public static final String DB_NAME = "Shop";
    public static final String ADDRESS = "localhost";
    public static final String PORT = "5432";

    @Override
    public Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + ADDRESS + ":" + PORT + "/" + DB_NAME,
                    USERNAME,
                    PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
