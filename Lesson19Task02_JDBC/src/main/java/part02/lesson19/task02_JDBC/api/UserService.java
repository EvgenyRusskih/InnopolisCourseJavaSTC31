package part02.lesson19.task02_JDBC.api;

import part02.lesson19.task02_JDBC.dao.UserDAO;
import part02.lesson19.task02_JDBC.dao.UserDAOImpl;
import part02.lesson19.task02_JDBC.dto.User;

import java.sql.Connection;

/**
 * CRUD operation for Users
 */
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserService(Connection connection) {
        this.userDAO = new UserDAOImpl(connection);
    }

    /**
     * Create User
     */
    public boolean createUser(String newName, String newLogin, String newPhone, int newIDarrd) {
        return userDAO.createUser(newName, newLogin, newPhone, newIDarrd);
    }

    /**
     * Read User
     */
    public String getUserInfo(String name) {
        User user = userDAO.getUser(name);
        return user.getName() + "    " + user.getLogin() + "    " + user.getPhone() + " " + user.getId_adress();

    }

    /**
     * Update User
     */
    public boolean setUserInfo(int id, String newName, String newLogin, String newPfone, int newIDarrd) {
        return userDAO.updateUser(id, newName, newLogin, newPfone, newIDarrd);
    }

    /**
     * Delete user
     */
    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }


    /**
     * Delete users range
     */
    public int deleteUsers(int idMin, int idMax) {
        return userDAO.deleteUsersRangeID(idMin, idMax);
    }

}
