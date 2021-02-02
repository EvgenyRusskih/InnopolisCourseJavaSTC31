package part02.lesson19.task01_JDBC;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import part02.lesson19.task01_JDBC.util.DBCreateTables;
import part02.lesson19.task01_JDBC.util.DB_Connection;
import part02.lesson19.task01_JDBC.util.DB_InsertTabels;
import part02.lesson19.task01_JDBC.util.DB_SelectData;

import java.sql.Connection;

/**
 * JDBC Task01. DB Shop - для онлаин магазина.
 * Описание прилагается в папке DOCS.
 * DB Shop - должна быть создана в Postgres (SQL скрипт прилагается в папке DOCS)
 * или можно создать инструментами типа PGAdmin.
 * Реализовано JDBC - создание таблиц, заполнение их тестовыми данными
 * получение данных из таблиц, вывод на печать
 */
public class MainClass {

    /**
     * Logger for Main class
     */
    private static final Logger LOGGER = LogManager.getLogger(MainClass.class.getName());

    public static void main(String[] args) {
        DB_Connection db_connection = new DB_Connection();
        Connection connectionShop = db_connection.getConnection();

        // CREATE TABLES DB SHOP
        DBCreateTables dbCreateTables = new DBCreateTables();
        dbCreateTables.createDBTables(connectionShop);

        // INSERT TEST DATA to TABLES DB SHOP
        DB_InsertTabels db_insertTabels = new DB_InsertTabels();
        db_insertTabels.insertDBTables(connectionShop);

        //SELECT DATA FROM DB SHOP
        LOGGER.info("");
        LOGGER.info("Select data from tabel Users");
        DB_SelectData db_selectData = new DB_SelectData();
        db_selectData.outSelectDataUsers(connectionShop);

        LOGGER.info("End program: OK");
    }

}
