import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        // connection to our database
        Connection conn = DbConnection.getConnection();

//        // select sql
////        String SQL_I = "INSERT INTO message (id, sender, content) VALUES (?, ?, ?)";
//        String SQL_I = "INSERT INTO message (sender, content) VALUES (?, ?)";
//        // statement
//        PreparedStatement stmti = conn.prepareStatement(SQL_I);
//        // setting data
////        stmti.setInt(1, 7);
//        stmti.setString(1, "Alexr");
//        stmti.setString(2, "Hello, World! ok");
//        // running
//        stmti.execute();


        // select sql
        String SQL_S = "SELECT * from users where id = ?";
        // statement
        PreparedStatement stmt = conn.prepareStatement(SQL_S);
        stmt.setInt(1, 33);
        // running
        ResultSet rset = stmt.executeQuery();
        // processing data
        while (rset.next()) {
            int id = rset.getInt("id");
            String name = rset.getString("name");
//            String sender = rset.getString("sender");
//            String sender2 = rset.getString("sender");
//            String content = rset.getString("content");
//            int id = rset.getInt("id");
//
//            String line = String.format("sender:%s, content:%s, id:%d", sender, content, id);
            String line = String.format("user:%s, id:%d", name, id);
            System.out.println(line);
        }
    }
}
