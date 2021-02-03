package part02.lesson15.task01_Singleton.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * REALIZE Singletone Synchronized Accessor pattern from DB connection

 * Нужно иметь один экземпляр соединения с базой
 * Это увеличивает производительность, тк не тратится время на пересоздание
 * обьекта соединения а берется созданный экземпляр.
 * Также это единая точка работы с БД, что уменьшает вероятность
 * возникновения ошибок и тупиковых ситуаций.
 */
public class SingletonPGConnection {
    /**
     * Singletone экземпляр для коннекта БД
     */
    private static Connection singletonPGConnectionInstance;

    /**
     * JDBC connection parameters
     */
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "postgres";
    public static final String DB_NAME = "Shop";
    public static final String ADDRESS = "localhost";
    public static final String PORT = "5432";


    public static synchronized Connection getPGConnectionInstance() {
        if(singletonPGConnectionInstance==null) {
            try {
                singletonPGConnectionInstance= DriverManager.getConnection(
                        "jdbc:postgresql://" + ADDRESS + ":" + PORT + "/" + DB_NAME,
                        USERNAME,
                        PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return singletonPGConnectionInstance;
    }


}
