package Banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Exceptions.AuthException;
import GUI.Menu;

public class Auth {

    public static User authenticateUser(Connection connection) throws AuthException {
        long phone;
        int pin = 0;
        String query = "select * from user where phone = ?";

        Scanner input = new Scanner(System.in);
        User user = null;

        System.out.print("Enter Your Phone Number : ");
        phone = input.nextLong();
        System.out.print("Enter Your Pin : ");
        pin = input.nextInt();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, phone);

            try(ResultSet result = statement.executeQuery()) {
                user = new User(
                       result.getInt("id"),
                       result.getString("name"),
                       result.getInt("age"),
                       result.getInt("phone"),
                       result.getInt("account"),
                       result.getInt("pin")
               );

               if(user.getName() == null) {
                   throw new AuthException("User Doesnot Exists");
               } else if(pin == user.getPin()) {
                   Menu menu = new Menu();
                   menu.Options(user, connection, input);
               } else {
                   throw new AuthException("Entered Wrong Pin");
               }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

}
