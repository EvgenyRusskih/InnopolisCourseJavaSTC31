package part02.lesson19.task01_JDBC.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс с настройками к БД
 * и методом получения нужного Connection
 */
public class DB_Connection {
    /**
     * DB connection parameters
     */
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "postgres";
    public static final String DB_NAME = "Shop";
    public static final String ADDRESS = "localhost";
    public static final String PORT = "5432";


    /**
     * Получаем connection к БД
     *
     * @return Connection database
     */
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

