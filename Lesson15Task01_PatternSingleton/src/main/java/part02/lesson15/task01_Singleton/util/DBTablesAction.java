package part02.lesson15.task01_Singleton.util;

import java.sql.Connection;

/**
 * Определим интерфейс для основных необходимых операций с таблицами БД
 * Создание таблиц.
 * Заполнение тестовыми данными.
 * Чтение таблиц.
 * Очистка таблиц
 */
public interface DBTablesAction {
    void createTables(Connection connection);
    void insertDataTables(Connection connection);
    void selectDataTable(Connection connection);
    void deleteDataTables(Connection connection);

}
