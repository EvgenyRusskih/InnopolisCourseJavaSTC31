package part02.lesson15.task01_Singleton.connection;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}
