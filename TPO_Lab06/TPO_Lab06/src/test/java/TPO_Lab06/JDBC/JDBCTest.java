package TPO_Lab06.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class JDBCTest {
    @Test
    public void testGetConnection() {
        try {
            Connection connection = DatabaseConnector.getConnection();
            Assertions.assertNotNull(connection);
            Assertions.assertFalse(connection.isClosed());
            connection.close();
            Assertions.assertTrue(connection.isClosed());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Assertions.fail("Failed to connect to the database.");
        }
    }
}
