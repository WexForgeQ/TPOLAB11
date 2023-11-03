package TPO_Lab06.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;


public class JDBCTest {
    @Test
    public void testGetConnection() {
        try {
            Connection connection = DatabaseConnector.getConnection();
            Assert.assertNotNull(connection);
            Assert.assertFalse(connection.isClosed());
            connection.close();
            Assert.assertTrue(connection.isClosed());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Failed to connect to the database.");
        }
    }
}
