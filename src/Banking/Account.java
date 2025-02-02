package Banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {

    private int id;
    private int account;
    private double balance;
    private String type;

    public Account(int id, int account, double balance, String type) {
        this.id = id;
        this.account = account;
        this.balance = balance;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Account getAccount(int account, Connection connection) throws SQLException {
        String query = "select * from accounts where account = ?";

        Account accountObj = null;
        Scanner input = new Scanner(System.in);

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, account);

            try(ResultSet result = statement.executeQuery()) {
                accountObj = new Account(
                        result.getInt("id"),
                        result.getInt("account"),
                        result.getDouble("balance"),
                        result.getString("type")
                );
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return accountObj;
    }
}
