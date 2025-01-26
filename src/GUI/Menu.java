package GUI;

import Banking.Operations;
import Banking.User;

import java.sql.Connection;
import java.util.Scanner;

public class Menu {

    public void Options(User user, Connection connection, Scanner input) {
        int selection = 0;


        while(selection != 4) {
            System.out.println("-----------------------------");
            System.out.println("1. Press 1 for withdrawal");
            System.out.println("2. Press 2 for Deposit");
            System.out.println("3. Press 3 for Balance Enquiry");
            System.out.println("4. Press 4 to Log Out");
            System.out.println("-----------------------------");

            System.out.print("Enter Your Choice : ");

            selection = input.nextInt();
            switch (selection) {
                case 1: {
                    Operations.withdrawal(user.getAccount(), connection, input);
                    break;
                }
                case 2: {
                    Operations.deposit(user.getAccount(), connection, input);
                    break;
                }
                case 3: {
                    Operations.getBalance(user.getAccount(), connection);
                    break;
                }
                case 4: {
                    System.out.println("Thank you for banking with us.");
                    break;
                }
                default: {
                    System.out.println("Invalid Input");
                    break;
                }
            }

        }

        input.close();
    }

}
