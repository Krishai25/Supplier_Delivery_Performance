package Database;
import java.sql.*;
import java.util.Scanner;

public class TestConnection {
    private static final String url = "jdbc:mysql://localhost:3306/supply_management";
    private static final String username = "root";
    private static final String password = "root";

    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            TestConnection.getconnection();
            System.out.println("Connection Established Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}