package part02.lesson19.task01_JDBC.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Получаем данные из DB Shop
 * и выводим их на экран
 * Непараметризированный запрос (обычный executeQuery)
 */
public class DB_SelectData {
    /**
     * Logger for this CLASS
     */
    private static final Logger LOGGER = LogManager.getLogger(DB_SelectData.class.getName());

    /**
     * Получение данных через обычный ResultSet
     *
     * @param connection connect to DB
     */
    public void outSelectDataUsers(Connection connection) {
        String sep = "       ";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet1 = statement.executeQuery("select * from \"Users\"");
            //Получим наименования столбцов таблицы и выведем их
            String colname1 = resultSet1.getMetaData().getColumnName(1);
            String colname2 = resultSet1.getMetaData().getColumnName(2);
            String colname3 = resultSet1.getMetaData().getColumnName(3);
            String colname4 = resultSet1.getMetaData().getColumnName(4);
            String colname5 = resultSet1.getMetaData().getColumnName(5);
            LOGGER.info("COLNAMES: " + colname1 + sep + colname2 + sep + colname3 + sep + colname4 + sep + colname5);

            while (resultSet1.next()) {
                int id = resultSet1.getInt(1);
                String name = resultSet1.getString(2);
                String login = resultSet1.getString(3);
                String phone = resultSet1.getString(4);
                int id_addres = resultSet1.getInt(5);
                LOGGER.info("USER:     " + id + sep + name + sep + login + sep + phone + sep + id_addres);
            }
            LOGGER.info("SELECT DATA from TABLE USERS: OK");
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

    }
}
