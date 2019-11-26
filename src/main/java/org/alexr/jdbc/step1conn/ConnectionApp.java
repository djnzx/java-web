package org.alexr.jdbc.step1conn;

import java.sql.Connection;

public class ConnectionApp {
  public static void main(String[] args) {
    // connection way # 1
    Connection conn1 = DbConnection.getConnection();
    // connection way # 2
    Connection conn2 = DbConnection2.getConnection();
  }
}
