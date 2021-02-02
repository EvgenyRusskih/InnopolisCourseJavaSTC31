package part02.lesson19.task01_JDBC.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Заполнение таблиц тестовыми данными БД Shop
 */
public class DB_InsertTabels {

    private static final Logger LOGGER = LogManager.getLogger(DB_InsertTabels.class.getName());

    public void insertDBTables(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(
                    "INSERT INTO public.\"Users\" \n" +
                            "VALUES \n" +
                            "(DEFAULT, 'EVG','e2e4','3412', 1),\n" +
                            "(DEFAULT, 'Alex','bestm','8909',2),\n" +
                            "(DEFAULT, 'Sergey','serg','50505',2),\n" +
                            "(DEFAULT, 'Tom','ttt','12345',3),\n" +
                            "(DEFAULT, 'Petr','trash','54321',4)\n" +
                            ";" +
                            "INSERT INTO public.\"Product\" \n" +
                            "VALUES \n" +
                            "(DEFAULT, 'Compute',50000,'Personal compute FULL SET 2020 year'),\n" +
                            "(DEFAULT, 'Acustic',10000,'Acustic universal microlab solo2'),\n" +
                            "(DEFAULT, 'HDD',5000,'Westen Digital'),\n" +
                            "(DEFAULT, 'CPU',22000,'INTEL PENTIUM Core I5 '),\n" +
                            "(DEFAULT, 'VideoCard',41000,'Nvidia GTX 3060')\n" +
                            ";" +
                            "INSERT INTO public.\"Orders\" \n" +
                            "VALUES \n" +
                            "(DEFAULT, 1, 0, 10000, 1 ),\n" +
                            "(DEFAULT, 2, 1, 5000, 0 ),\n" +
                            "(DEFAULT, 3, 0, 50000, 1 )\n" +
                            ";");

            LOGGER.info("INSERT DATA to TABLES: OK");
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

    }

}
