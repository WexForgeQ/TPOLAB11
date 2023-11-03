package TPO_Lab06.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataModifier {

    public static void deleteMoviesOlderThanYears(int years) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM Movies WHERE release_date < DATE_SUB(NOW(), INTERVAL ? YEAR)");

        statement.setInt(1, years);
        statement.executeUpdate();
    }

}