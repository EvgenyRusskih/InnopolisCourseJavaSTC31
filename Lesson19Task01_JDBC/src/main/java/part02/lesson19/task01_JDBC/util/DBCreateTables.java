package part02.lesson19.task01_JDBC.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Создание таблиц БД Shop (если их не существует)
 */
public class DBCreateTables {

    private static final Logger LOGGER = LogManager.getLogger(DBCreateTables.class.getName());

    /**
     * Создание таблиц в БД если этих таблиц еще нет в БД
     *
     * @param connection connect DB
     */
    public void createDBTables(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(
                    " CREATE TABLE IF NOT EXISTS public.\"Users\"\n" +
                            "\t(\"ID\" SERIAL, \n" +
                            " \t\"Name\" VARCHAR(100),  \n" +
                            "    \"Login\" VARCHAR(100),\n" +
                            "    \"Phone\" VARCHAR(100),\n" +
                            "    \"ID_Adress\" INTEGER\n" +
                            "    );" +
                            "CREATE TABLE IF NOT EXISTS public.\"Product\"\n" +
                            "\t(\"ID\" SERIAL, \n" +
                            " \t\"Name\" VARCHAR(100),  \n" +
                            "    \"Price\" INTEGER,\n" +
                            "    \"Description\" VARCHAR(500)\n" +
                            "    );  " +
                            "CREATE TABLE IF NOT EXISTS public.\"Orders\"\n" +
                            "\t(\"ID\" SERIAL, \n" +
                            " \t\"ID_User\" INTEGER,  \n" +
                            "    \"Delivery\" SMALLINT,\n" +
                            "    \"SUM\" INTEGER,\n" +
                            "     Status SMALLINT\n" +
                            "    );  " +
                            "");
            LOGGER.info("CREATE TABLES IF NOT EXISTS: OK");
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
    }
}
