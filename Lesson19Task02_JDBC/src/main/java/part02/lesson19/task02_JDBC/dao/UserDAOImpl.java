package part02.lesson19.task02_JDBC.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import part02.lesson19.task02_JDBC.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * CRUD realize for User
 * and delete All user for range ID (butch)
 */
public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = LogManager.getLogger(UserDAOImpl.class.getName());
    private final Connection connection;


    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Поиск и получение пользователя по имени
     *
     * @param username имя для поиска
     * @return User
     */
    @Override
    public User getUser(String username) {
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from \"Users\" where \"Name\" = ?")) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                    user.setName(resultSet.getString(2));
                    user.setLogin(resultSet.getString(3));
                    user.setPhone(resultSet.getString(4));
                    user.setId_adress(resultSet.getInt(5));
                }
            }
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
        return user;

    }

    /**
     * Создание нового пользователя
     */
    @Override
    public boolean createUser(String name, String login, String phone, int idAddr) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO  \"Users\" (\"Name\", \"Login\", \"Phone\", \"ID_Adress\") VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, phone);
            preparedStatement.setInt(4, idAddr);
            int countUdate = preparedStatement.executeUpdate();
            if (countUdate > 0) {
                return true;
            }
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
        return false;
    }

    /**
     * Обновление данных пользователя по ID
     */
    @Override
    public boolean updateUser(int id, String newName, String newLogin, String newPhone, int newIdAddr) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "update  \"Users\" set (\"Name\", \"Login\", \"Phone\", \"ID_Adress\")=(?, ?, ?, ?)" +
                        "where \"ID\"=? ")) {
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newLogin);
            preparedStatement.setString(3, newPhone);
            preparedStatement.setInt(4, newIdAddr);
            preparedStatement.setInt(5, id);
            int countUdate = preparedStatement.executeUpdate();
            if (countUdate > 0) {
                return true;
            }
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
        return false;

    }

    /**
     * Удаление пользователя по ID
     */
    @Override
    public boolean deleteUser(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from \"Users\" where \"ID\"=? ")) {
            preparedStatement.setInt(1, id);
            int countUdate = preparedStatement.executeUpdate();
            if (countUdate > 0) {
                return true;
            }
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
        return false;
    }


    /**
     * Метод удаляет записи в таюлице по диапазону ID
     * В методе используется батчинг для более эффективного выполнения
     * однотипных запросов
     */
    @Override
    public int deleteUsersRangeID(int id_min, int id_max) {
        int countDelete = 0;
        for (int i = id_min; i <= id_max; i++) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from \"Users\" where \"ID\"=? ")) {
                preparedStatement.setInt(1, i);
                //примняем батчинг для большого количества однотипных операций
                preparedStatement.addBatch();
                countDelete = countDelete + preparedStatement.executeUpdate();

            } catch (SQLException exception) {
                LOGGER.error(exception.getMessage());
            }

        }
        return countDelete;
    }

}
