package jdbc.step9extra;

import jdbc.step1conn.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class ExtraApp {

  public static void main(String[] args) throws SQLException {
    Connection conn = DbConnection.getConnection();
    // turn off default auto commit
    conn.setAutoCommit(false);
    // ...
    try {
      // insert
      // select
      // update
      // delete
      conn.commit();
    } catch (SQLException e) {
      conn.rollback();
    }
    // set different transaction isolation levels
    conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
    conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
    conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

    int isolation = conn.getTransactionIsolation();
    if (isolation == Connection.TRANSACTION_REPEATABLE_READ) {}

  }
}
