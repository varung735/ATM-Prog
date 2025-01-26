package Banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import GUI.Menu;

public class Auth {

    public static User authenticateUser(Connection connection){
        long phone;
        int pin;
        String query = "select * from user where phone = ?";

        Scanner input = new Scanner(System.in);
        User user = null;

        System.out.print("Enter Your Phone Number : ");
        phone = input.nextLong();
        System.out.print("Enter Your Secret Pin : ");
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
                   System.out.println("User Doesn't Exists");
               } else if(pin == user.getPin()) {
                   Menu menu = new Menu();
                   menu.Options(user, connection, input);
               } else {
                   System.out.println("Entered Wrong Pin");
               }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

//    public static void logout(Connection connection, Scanner input) {
//
//    }

}
