
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleDatabaseConnection {
	public static void main(String[] args) {

		// Corrected JDBC URL
		String jdbcUrl = "jdbc:mysql://localhost:3306/mydatabase";  // Changed 'msql' to 'mysql'
		String username = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
			System.out.println("Database Connection Successful");
		} catch (SQLException e) {
			System.err.println("Error in Database Connection: " + e.getMessage());  // Added exception message
			e.printStackTrace();  // Print the stack trace for more details
		}
	}
}
