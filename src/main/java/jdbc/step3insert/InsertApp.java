package jdbc.step3insert;

import jdbc.step1conn.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {
  final static String SQLI = "INSERT INTO message1 (id, sender, content) VALUES (?, ?, ?)";

  public static void main(String[] args) throws SQLException {
    Connection conn = DbConnection.getConnection();
    PreparedStatement stmt = conn.prepareStatement(SQLI);
    stmt.setLong(1, 10);
    stmt.setLong(2, 11);
    stmt.setString(3, "hello");
    stmt.execute();
  }
}
