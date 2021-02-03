package part02.lesson15.task01_Singleton;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import part02.lesson15.task01_Singleton.connection.SingletonPGConnection;
import part02.lesson15.task01_Singleton.util.DBTablesAction;
import part02.lesson15.task01_Singleton.util.DBTablesActionImpl;

import java.sql.Connection;

/**
 * DZ15 (Extends DZ_19-Task01) Singleton creation GOF patterns example
 * REALIZE Singletone Synchronized Accessor
 * За основу возьмем ДЗ-19 Task01
 * Применим паттерн singleton к подключению к БД.
 * Нам нужно единственное подключение в пределах нашего thread and classloader scope.
 * Нужно иметь один экземпляр соединения с базой
 * Это увеличивает производительность, тк не тратится время на пересоздание тяжелого
 * обьекта соединения а берется созданный экземпляр.
 * Также это единая точка работы с БД, что уменьшает вероятность
 * возникновения ошибок противоречий и тупиковых ситуаций.
 */
public class MainClass {
    private static final Logger LOGGER = LogManager.getLogger(MainClass.class.getName());

    public static void main(String[] args) {
       Connection connectPgInstance=SingletonPGConnection.getPGConnectionInstance();
       Connection connectPgInstance2=SingletonPGConnection.getPGConnectionInstance();
       LOGGER.info("SINGLETONE Object connection DB ");
       LOGGER.info(connectPgInstance.toString() );
       LOGGER.info(connectPgInstance2.toString() );
       LOGGER.info("");
       LOGGER.info(" ------------------ ");

       DBTablesAction dbTablesAction=new DBTablesActionImpl();
       dbTablesAction.createTables(connectPgInstance);
       dbTablesAction.insertDataTables(connectPgInstance);
       dbTablesAction.selectDataTable(connectPgInstance);
       dbTablesAction.deleteDataTables(connectPgInstance);

    }

}
