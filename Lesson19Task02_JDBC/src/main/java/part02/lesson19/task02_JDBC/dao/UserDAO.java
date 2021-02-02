package part02.lesson19.task02_JDBC.dao;

import part02.lesson19.task02_JDBC.dto.User;

/**
 * CRUD Operations for Users
 */
public interface UserDAO {
    User getUser(String username);
    boolean createUser(String name,String login,String phone,int idAddr);
    boolean updateUser(int id, String newName,String newLogin,String newPhone,int newIdAddr);
    boolean deleteUser(int id);
    int deleteUsersRangeID(int id_min, int id_max);

}
