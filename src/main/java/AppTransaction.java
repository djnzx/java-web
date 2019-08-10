import java.sql.Connection;
import java.sql.SQLException;

public class AppTransaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = new DbConnection2().get();

        // turn off default auto commit
        connection.setAutoCommit(false);

        // commit / rollback
        connection.commit();
        connection.rollback();

        // set different transaction isolation levels
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

        connection.getTransactionIsolation();

    }
}
