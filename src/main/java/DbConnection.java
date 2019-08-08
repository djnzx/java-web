import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final static String DB_URL = "jdbc:postgresql://localhost:5432/wt";
    private final static String USER_NAME = "postgres";
    private final static String USER_PASS = "secret";

    private static Connection connection = null;

    private DbConnection() {}

    static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
