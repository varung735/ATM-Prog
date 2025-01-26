package Banking;

public class User {

    private int id;
    private String name;
    private int age;
    private long phone;
    private int account;
    private int pin;

    public User(int id, String name, int age, long phone, int account, int pin) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.account = account;
        this.pin = pin;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
