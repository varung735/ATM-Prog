package Banking;

import Exceptions.AmountException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Operations {

    public static void withdrawal(int account, Connection connection, Scanner input) throws AmountException {
        double amount = 0;
        double balance = 0;
        double newBalance = 0;

        System.out.print("Enter the Desired Amount for Withdrawal : ");
        amount = input.nextDouble();

        Account accountObj = null;
        try {
            accountObj = Account.getAccount(account, connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        if(accountObj != null) {
            balance = accountObj.getBalance();
        }

        if(amount > balance) {
            throw new AmountException("Insufficient funds for withdrawal");
        }

        newBalance = balance - amount;

        try {
            String updateQuery = "update accounts set balance = ? where id = ?";
            String getQuery = "select * from accounts where account = ?";

            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            PreparedStatement getStatement = connection.prepareStatement(getQuery);

            updateStatement.setDouble(1, newBalance);
            assert accountObj != null;
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
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deposit(int account, Connection connection, Scanner input) throws AmountException {
        double amount = 0;
        double balance = 0;
        double newBalance = 0;

        System.out.print("Enter the Desired Amount for Deposit : ");
        amount = input.nextDouble();

        if(amount < 0) {
            throw new AmountException("The Deposit should be greater than $0");
        }

        Account accountObj = null;
        try {
            accountObj = Account.getAccount(account, connection);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        assert accountObj != null;
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
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getBalance(int account, Connection connection) {
        Account accountObj = null;
        double balance = 0;
        try {
            accountObj = Account.getAccount(account, connection);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        if(accountObj != null) {
            balance = accountObj.getBalance();
        }

        System.out.println("Your current balance in your account is : " + balance);
    }
}
