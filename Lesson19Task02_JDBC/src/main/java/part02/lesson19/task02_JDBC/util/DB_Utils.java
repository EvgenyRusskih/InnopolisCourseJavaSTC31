package part02.lesson19.task02_JDBC.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс реализует пересоздание таблиц и наполнение
 * этих таблиц тестовыми данными
 */
public class DB_Utils {
    /**
     * Logger LOG4G
     */
    private static final Logger LOGGER = LogManager.getLogger(DB_Utils.class.getName());

    /**
     * Метод сброса и инициализации базы данных (пересоздание таблиц)
     * @param connection connect to DB
     */
    public void renewDatabase(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            // Удаляем таблицы если они существуют
            statement.execute("drop table IF EXISTS public.\"Users\";" +
                    "drop table IF EXISTS public.\"Product\";" +
                    "drop table IF EXISTS public.\"Orders\";" +
                    "");
            // Создаем таблицы
            statement.execute(" CREATE TABLE IF NOT EXISTS public.\"Users\"\n" +
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

            // Наполняем таблицы тестовыми данными
            statement.execute("INSERT INTO public.\"Users\" \n" +
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

            LOGGER.info("RENEW DB Shop: OK");

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

    }


}
