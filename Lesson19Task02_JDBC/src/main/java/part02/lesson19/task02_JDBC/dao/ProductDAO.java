package part02.lesson19.task02_JDBC.dao;

import part02.lesson19.task02_JDBC.dto.Product;

/**
 * * CRUD Operations for Product
 */
public interface ProductDAO {
    Product getProduct(String name);
    boolean addProduct(String name,int price, String description);
    boolean updateProduct(int id, String newName,int newPrice, String newDescription);
    boolean deleteProduct(int id);
}
