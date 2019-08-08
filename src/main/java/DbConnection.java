import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final static String DB_URL = "jdbc:postgresql://localhost:5432/wt";
    private final static String USER_NAME = "postgres";
    private final static String USER_PASS = "secret";

    static Connection getConnection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conection;
    }

}
