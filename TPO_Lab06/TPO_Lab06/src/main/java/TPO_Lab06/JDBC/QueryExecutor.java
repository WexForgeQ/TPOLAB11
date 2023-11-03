package TPO_Lab06.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecutor {

    public static ResultSet executeQuery(String query, Object... parameters) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }

        return statement.executeQuery();
    }

}