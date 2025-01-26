import java.sql.Connection;

import static Banking.Auth.authenticateUser;
import static Database.Connect.connect;

public class Main {
    public static void main(String[] args) {
        try{
            Connection connection = connect();
            authenticateUser(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}