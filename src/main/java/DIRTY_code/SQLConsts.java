package DIRTY_code;

public class SQLConsts {
    /**
     * 1. Int - User id
     * 2. String - sender name
     * 3. String - message text
     */
    final static String SQLI = "INSERT INTO message (id, sender, content) VALUES (?, ?, ?)";
    final static String SQLS = "SELECT * FROM message";
}
