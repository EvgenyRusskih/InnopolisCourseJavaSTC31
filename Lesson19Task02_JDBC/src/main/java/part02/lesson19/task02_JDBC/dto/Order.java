package part02.lesson19.task02_JDBC.dto;

public class Order {
    private int id;
    private int id_user;
    private short delivery;
    private int sum;
    private short status;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public short getDelivery() {
        return delivery;
    }

    public void setDelivery(short delivery) {
        this.delivery = delivery;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

}
