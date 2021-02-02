package part02.lesson19.task02_JDBC.dao;

import part02.lesson19.task02_JDBC.dto.Order;

/**
 * CRUD Operations for order
 */
public interface OrderDAO {
    Order getOrde(int id);
    boolean addOrde(int id,int id_user, short delivery,int sum,short status);
    boolean updateOrde(int id,int newId_user, short newDelivery,int newSum,short newStatus);
    boolean deleteOrde(int id);
}
