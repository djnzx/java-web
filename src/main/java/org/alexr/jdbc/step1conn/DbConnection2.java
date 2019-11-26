package org.alexr.jdbc.step1conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection2 {
  private static final String DB_URL = "jdbc:postgresql://localhost:5432/ibatech";
  private static final Properties props = new Properties(){{
    setProperty("user","postgres");
    setProperty("password","secret");
    setProperty("ssl","false");
  }};

  private static Connection connection;

  private DbConnection2() {}

  public static Connection getConnection() {
    if (connection == null) {
      try {
        connection = DriverManager.getConnection(DB_URL, props);
      } catch (SQLException e) {
        throw new RuntimeException("Something went wrong during connection", e);
      }
    }
    return connection;
  }
}
