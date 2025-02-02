import Exceptions.AuthException;

import java.sql.Connection;
import java.sql.SQLException;

import static Banking.Auth.authenticateUser;
import static Database.Connect.connect;

public class Main {
    public static void main(String[] args) {
        try{
            Connection connection = null;

            try {
                connection = connect();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            authenticateUser(connection);
        } catch (AuthException e) {
            System.out.println(e.getMessage());
        }
    }
}