package part02.lesson19.task02_JDBC.dto;

public class User {

    private int id;
    private String name;
    private String login;
    private String phone;
    private int id_adress;


    /**
     * Getters and setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId_adress() {
        return id_adress;
    }

    public void setId_adress(int id_adress) {
        this.id_adress = id_adress;
    }

}
