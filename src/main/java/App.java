import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        // connection to our database
        Connection conn = new DbConnection2().get();
//        Connection conn = DbConnection.getConnection();

        // select sql
//        String SQL_I = "INSERT INTO message (id, sender, content) VALUES (?, ?, ?)";
        // statement
        PreparedStatement stmti = conn.prepareStatement(SQLConsts.SQLI);
        // setting data
        stmti.setInt(1, 7);
        stmti.setString(2, "Alexr");
        stmti.setString(3, "Hello World!");
        // running
        stmti.execute();


        // select sql
//        String SQL_S = "SELECT * FROM message";
        // statement
        PreparedStatement stmt = conn.prepareStatement(SQLConsts.SQLS);
        // running
        ResultSet rset = stmt.executeQuery();
        // processing data
        while (rset.next()) {
            String line = String.format("sender:%s, content:%s, id:%d",
                    rset.getString("sender"),
                    rset.getString("content"),
                    rset.getInt("id"));
            System.out.println(line);
        }
    }
}
