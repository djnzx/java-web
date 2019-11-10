package jdbc.step2createtable;

import jdbc.step1conn.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableApp {
  public static void main(String[] args) throws SQLException {
    // 1
    Connection conn = DbConnection.getConnection();

    String SQL = "create table messages1 (\n" +
        "    id bigserial not null\n" +
        "        constraint messages_pk\n" +
        "\t\t\tprimary key,\n" +
        "\tsrc bigint not null,\n" +
        "\tdst bigint not null,\n" +
        "\ttext varchar\n" +
        ");\n";
    // 2
    PreparedStatement stmt = conn.prepareStatement(SQL);
    stmt.execute();
  }
}
