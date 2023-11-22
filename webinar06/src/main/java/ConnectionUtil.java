import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "user", "pass");
        } catch (SQLException e) {
            throw new RuntimeException("Нет коннекта", e);
        }
        return connection;
    }
}
