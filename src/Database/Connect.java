package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection connect() throws SQLException {
        String db_file = "jdbc:sqlite:Resources/Bank.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(db_file);
            System.out.println("We're connected to database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

}
