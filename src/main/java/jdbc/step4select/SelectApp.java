package jdbc.step4select;

import jdbc.step1conn.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectApp {
  final static String SQLS = "SELECT * FROM message1";

  public static void main(String[] args) throws SQLException {
    Connection conn = DbConnection.getConnection();
    PreparedStatement stmt = conn.prepareStatement(SQLS);
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
