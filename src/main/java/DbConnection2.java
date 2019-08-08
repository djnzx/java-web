import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection2 {
    private final String DB_URL = "jdbc:postgresql://localhost:5432/wt";
    private final String USER_NAME = "postgres";
    private final String USER_PASS = "secret";
    private Connection conection = null;

    public Connection get() {
        if (conection == null) {
            try {
                conection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conection;
    }

}
