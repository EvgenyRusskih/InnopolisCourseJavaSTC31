package part02.lesson15.task01_Singleton.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Реализованы основные операции с таблицами БД
 * Создание, заполнение, очистка и выборка таблиц.
 */
public class DBTablesActionImpl implements DBTablesAction {

    private static final Logger LOGGER = LogManager.getLogger(DBTablesActionImpl.class.getName());

    /**
     * Method implement create all tables for DB Shop
     * @param connection Connect DB
     */
    public void createTables(Connection connection) {
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


    /**
     * Method implement insert test data to all tables for DB Shop
     * @param connection Connect DB
     */
    public void insertDataTables(Connection connection) {
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



    /**
     * Method implement select test data to all tables for DB Shop
     * @param connection Connect to DB
     */
    public void selectDataTable(Connection connection) {
        String sep = "       ";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet1 = statement.executeQuery("select * from \"Users\"");
            ResultSet resultSet2 = statement.executeQuery("select * from \"Product\"");
            ResultSet resultSet3 = statement.executeQuery("select * from \"Orders\"");
            //Получим наименования столбцов таблицы и выведем их
            String colname1 = resultSet1.getMetaData().getColumnName(1);
            String colname2 = resultSet1.getMetaData().getColumnName(2);
            String colname3 = resultSet1.getMetaData().getColumnName(3);
            String colname4 = resultSet1.getMetaData().getColumnName(4);
            String colname5 = resultSet1.getMetaData().getColumnName(5);
            LOGGER.info("--------------- ");
            LOGGER.info("READ USERS --------------- ");
            LOGGER.info("COLNAMES: " + colname1 + sep + colname2 + sep + colname3 + sep + colname4 + sep + colname5);
            while (resultSet1.next()) {
                int id = resultSet1.getInt(1);
                String name = resultSet1.getString(2);
                String login = resultSet1.getString(3);
                String phone = resultSet1.getString(4);
                int idAddres = resultSet1.getInt(5);
                LOGGER.info("USER:     " + id + sep + name + sep + login + sep + phone + sep + idAddres);
            }
            LOGGER.info("--------------- ");
            LOGGER.info("READ PRODUCTS --------------- ");
            while (resultSet2.next()) {
                int id = resultSet2.getInt(1);
                String name = resultSet2.getString(2);
                int price = resultSet2.getInt(3);
                String description = resultSet2.getString(4);
                LOGGER.info("Product:     " + id + sep + name + sep + price + sep + description);

            }
            LOGGER.info("--------------- ");
            LOGGER.info("READ ORDERS --------------- ");
            while (resultSet3.next()) {
                int id = resultSet3.getInt(1);
                int idUser = resultSet3.getInt(2);
                short delivery = resultSet3.getShort(3);
                int sum = resultSet3.getInt(4);
                int status= resultSet3.getInt(5);
                LOGGER.info("Order:     " + id + sep + idUser + sep + delivery + sep + sum +sep+status);
            }

            LOGGER.info("SELECT ALL DATA from TABLE USERS: OK");
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
    }


    /**
     * Method implement delete test data to all tables for DB Shop
     * @param connection Connect DB
     */
    @Override
    public void deleteDataTables(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from \"Users\"");
            statement.executeUpdate("delete from \"Product\"");
            statement.executeUpdate("delete from \"Orders\"");
            LOGGER.info("DELETING Tables Test DATA: OK");
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

    }



}
