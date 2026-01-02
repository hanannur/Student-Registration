package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Note: In a real app, never hardcode passwords.
    // Ideally, keep using getenv, but ensure you set them in your Run Configuration.
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Try to get from Environment Variables first
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        // FALLBACK: If env vars are null, use defaults (For development only!)
        if (user == null) user = "root";
        if (password == null) password = "your_actual_password_here";

        return DriverManager.getConnection(URL, user, password);
    }
}