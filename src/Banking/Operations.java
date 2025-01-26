package Banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Operations {

    public static void withdrawal(int account, Connection connection, Scanner input) {
        double amount = 0;
        double balance = 0;
        double newBalance = 0;

        System.out.print("Enter the Desired Amount for Withdrawal : ");
        amount = input.nextDouble();

        Account accountObj = Account.getAccount(account, connection);
        balance = accountObj.getBalance();

        newBalance = balance - amount;

        try {
            String updateQuery = "update accounts set balance = ? where id = ?";
            String getQuery = "select * from accounts where account = ?";

            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            PreparedStatement getStatement = connection.prepareStatement(getQuery);

            updateStatement.setDouble(1, newBalance);
            updateStatement.setInt(2, accountObj.getId());

            getStatement.setInt(1, accountObj.getAccount());

            updateStatement.executeUpdate();

            try(ResultSet result = getStatement.executeQuery()) {
                accountObj.setId(result.getInt("id"));
                accountObj.setAccount(result.getInt("account"));
                accountObj.setBalance(result.getDouble("balance"));
                accountObj.setType(result.getString("type"));

                System.out.println("Your Remaining Balance is : " + accountObj.getBalance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deposit(int account, Connection connection, Scanner input) {
        double amount = 0;
        double balance = 0;
        double newBalance = 0;

        System.out.print("Enter the Desired Amount for Deposit : ");
        amount = input.nextDouble();

        Account accountObj = Account.getAccount(account, connection);
        balance = accountObj.getBalance();

        newBalance = balance + amount;

        try {
            String updateQuery = "update accounts set balance = ? where id = ?";
            String getQuery = "select * from accounts where account = ?";

            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            PreparedStatement getStatement = connection.prepareStatement(getQuery);

            updateStatement.setDouble(1, newBalance);
            updateStatement.setInt(2, accountObj.getId());

            getStatement.setInt(1, accountObj.getAccount());

            updateStatement.executeUpdate();

            try(ResultSet result = getStatement.executeQuery()) {
                accountObj.setId(result.getInt("id"));
                accountObj.setAccount(result.getInt("account"));
                accountObj.setBalance(result.getDouble("balance"));
                accountObj.setType(result.getString("type"));

                System.out.println("Your Updated Balance is : " + accountObj.getBalance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getBalance(int account, Connection connection) {
        Account accountObj = Account.getAccount(account, connection);

        System.out.println("Your current balance in your account is : " + accountObj.getBalance());
    }
}
