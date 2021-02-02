package part02.lesson19.task02_JDBC.api;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * DEMO Transact jdbc database Shop.
 * Реализация ручное управление транзакциями, savepoint
 * Демностнация отката транзакции к savepoint.
 */
public class DemoTransactJDBC {

    private static final Logger LOGGER = LogManager.getLogger(DemoTransactJDBC.class.getName());
    private final Connection connection;

    public DemoTransactJDBC(Connection connection) {
        this.connection = connection;
    }

    /**
     * DEMO Savepoint
     * Происходит откат транзакции ко 2 му запросу
     * 1 -ый запрос выполняется, 2 - запроса откатываются
     * Принимаем три параметра 1,2,3 транзакции
     */
    public void createAllInfoTabsImpl(String userName, String productName, int sum ) {
        String insertSQL_Tab1="INSERT INTO public.\"Users\" \n" +
                "VALUES \n" +
                "(DEFAULT, '"+ userName+"','Utransact','5000', 18);";
        String insertSQL_Tab2="INSERT INTO public.\"Product\" \n" +
                "VALUES \n" +
                "(DEFAULT,'"+ productName+ "',31000,'Personal compute FULL SET 2021 year');";
        String insertSQL_Tab3="INSERT INTO public.\"Orders\" \n" +
                "VALUES \n" +
                "(DEFAULT, 2, 1,"+ sum+", 8 );";

        try (PreparedStatement preparedStatementUser = connection.prepareStatement(insertSQL_Tab1)) {
            // Устанавливаем ручное управление транзакцией
            connection.setAutoCommit(false);
            preparedStatementUser.executeUpdate();

            PreparedStatement preparedStatementProduct=connection.prepareStatement(insertSQL_Tab2);
            Savepoint savepointTab2=connection.setSavepoint("insertUsers:tab2");
            preparedStatementProduct.executeUpdate();

            // Откат к savepoint в случае сбоя при записи
            try {
                PreparedStatement preparedStatementOrder=connection.prepareStatement(insertSQL_Tab3);
                preparedStatementOrder.executeUpdate();

                throw new SQLException();
            } catch (SQLException exception) {
                connection.rollback(savepointTab2);

            }
            finally {
                connection.commit();
                connection.setAutoCommit(true);

            }
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }


    }

    /**
     * Вывод всех Users в таблице
     */
    public void printAllUsers() {
        String selectAll="select * from public.\"Users\";";
        String strOut;
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAll)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    strOut=resultSet.getString(1)+"; "+  resultSet.getString(2)+"; "+
                            resultSet.getString(3)+"; "+resultSet.getString(4)+"; "+
                            resultSet.getString(5);

                    LOGGER.info("User:   "+strOut);
                }
            }
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
    }


    /**
     * Вывод всех Products в таблице
     */
    public void printAllProdicts() {
        String selectAll = "select * from public.\"Product\";";
        String strOut;
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAll)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    strOut = resultSet.getString(1) + "; " + resultSet.getString(2) + "; " +
                            resultSet.getString(3) + "; " + resultSet.getString(4) + "; ";

                    LOGGER.info("Product:   " + strOut);
                }
            }
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
    }


    /**
     * Вывод всех Orders в таблице
     */
    public void printAllOrders() {
        String selectAll = "select * from public.\"Orders\";";
        String strOut;
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAll)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    strOut = resultSet.getString(1) + "; " + resultSet.getString(2) + "; " +
                            resultSet.getString(3) + "; " + resultSet.getString(4) + "; "+
                            resultSet.getString(5);

                    LOGGER.info("Product:   " + strOut);
                }
            }
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
    }

}
