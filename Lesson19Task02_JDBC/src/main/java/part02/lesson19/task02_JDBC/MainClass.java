package part02.lesson19.task02_JDBC;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import part02.lesson19.task02_JDBC.api.DemoTransactJDBC;
import part02.lesson19.task02_JDBC.api.UserService;
import part02.lesson19.task02_JDBC.connections.PostgresConnectionManager;
import part02.lesson19.task02_JDBC.util.DB_Utils;

import java.sql.Connection;

/**
 * Lesson19 Task02 JDBC
 * DB Shop(пустая) - должна быть создана в Postgres. Можно создать инструментами типа PGAdmin.
 * CRUD JDBC database prepared statement for Users
 * JDBC Transact and savepoint DEMO
 */
public class MainClass {
    /**
     * Logger LOG4G
     */
    private static final Logger LOGGER = LogManager.getLogger(MainClass.class.getName());

    public static void main(String[] args) {
        PostgresConnectionManager postgresConnectionManager=new PostgresConnectionManager();
        Connection connectShop =postgresConnectionManager.getConnection();

        //Renew database Shop (сброс и переинициализация БД)
        DB_Utils db_utils=new DB_Utils();
        db_utils.renewDatabase(connectShop);

        // CRUD JDBC prepared statement
        LOGGER.info("CRUD с использованием jdbc prepared statement: START");
        UserService userService=new UserService(connectShop);

        // Create User Пользователь создается и находистя по имени
        String userNameCreate="User2";
        if (userService.createUser(userNameCreate,"Login2","55545",4)) {
            LOGGER.info("Create user:   "+userNameCreate+"  OK");
        }

        // Read User Info
        LOGGER.info("Read user: "+userService.getUserInfo("User2")+"    OK");

        // Update User Получаем User Info
        String userNameUpdate="Alex";
        LOGGER.info("Update user old INFO: "+ userService.getUserInfo(userNameUpdate) +"   OK");
        userService.setUserInfo(1,"Alex","setLogo","5454",3);
        LOGGER.info("Update user new INFO: "+ userService.getUserInfo(userNameUpdate) +"   OK");

        // Delete User
        int idUserDel=2;
        if(userService.deleteUser(idUserDel)) {
            LOGGER.info("Delete User from ID:= "+ idUserDel +"    OK ");
        }
        else {LOGGER.info("User from ID : not found"); }

        LOGGER.info(" ---------------- ");
        // Delete Users range
        int deleteUsersCount =(userService.deleteUsers(3,5));
        if(deleteUsersCount>0) {
            LOGGER.info("Use batching:  Delete  Users count:= "+deleteUsersCount+"   OK");
        }
        else {LOGGER.info("Users : not found"); }

        //Use transaction and savepoint DEMO
        LOGGER.info("JDBC Transact and savepoint DEMO с параметрами для 1,2,3 табл");
        DemoTransactJDBC demoTransactJDBC=new DemoTransactJDBC(connectShop);
        LOGGER.info(" ---------------- ");
        demoTransactJDBC.createAllInfoTabsImpl("UserTransact1", "ProductTransact2",11111);
        demoTransactJDBC.printAllUsers();
        LOGGER.info("Параметр для 1 транзакции (UserTransact1) видим в списке ");
        LOGGER.info(" ---------------- ");
        demoTransactJDBC.printAllProdicts();
        LOGGER.info("Параметр для 2 транзакции (ProductTransact2) остуствует в списке ");
        LOGGER.info(" ---------------- ");
        demoTransactJDBC.printAllUsers();
        LOGGER.info("Параметр для 3 транзакции (11111) остуствует в списке ");
        LOGGER.info(" ---------------- ");
        LOGGER.info("Таким образом транзакция откатилась к savepoint в методе  createAllInfoTabsImpl");

        LOGGER.info(" ---------------- ");
        LOGGER.info("END program: OK");
    }

}
