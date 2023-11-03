package TPO_Lab06.JDBC;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Найти все фильмы, вышедшие на экран в текущем и прошлом году
            findMoviesReleasedInCurrentAndPreviousYear();

            // Вывести информацию об актерах, снимавшихся в заданном фильме
            String movieTitle = "Фильм 1";
            printActorsInMovie(movieTitle);

            // Вывести информацию об актерах, снимавшихся как минимум в N фильмах
            int minMoviesCount = 2;
            printActorsInNMovies(minMoviesCount);

            // Вывести информацию об актерах, которые были режиссерами хотя бы одного из фильмов
            printActorDirectors();

            // Удалить все фильмы, дата выхода которых была более заданного числа лет назад
            //int yearsAgo = 5;
            //deleteMoviesOlderThanYears(yearsAgo);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void findMoviesReleasedInCurrentAndPreviousYear() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM Movies WHERE YEAR(release_date) >= YEAR(CURDATE()) - 1";
        ResultSet resultSet = QueryExecutor.executeQuery(query);

        System.out.println("Movies released in current and previous year:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            Date releaseDate = resultSet.getDate("release_date");
            String country = resultSet.getString("country");

            System.out.println("ID: " + id + ", Title: " + title + ", Release Date: " + releaseDate + ", Country: " + country);
        }

        resultSet.close();
    }

    public static void printActorsInMovie(String movieTitle) throws SQLException, ClassNotFoundException {
        String query = "SELECT a.full_name FROM Actors a " +
                "JOIN MovieActors ma ON a.id = ma.actor_id " +
                "JOIN Movies m ON ma.movie_id = m.id " +
                "WHERE m.title = ?";
        ResultSet resultSet = QueryExecutor.executeQuery(query, movieTitle);

        System.out.println("Actors in movie '" + movieTitle + "':");
        while (resultSet.next()) {
            String actorFullName = resultSet.getString("full_name");
            System.out.println(actorFullName);
        }

        resultSet.close();
    }

    public static void printActorsInNMovies(int minMoviesCount) throws SQLException, ClassNotFoundException {
        String query = "SELECT a.full_name, COUNT(ma.movie_id) AS movies_count FROM Actors a " +
                "JOIN MovieActors ma ON a.id = ma.actor_id " +
                "GROUP BY a.id " +
                "HAVING COUNT(ma.movie_id) >= ?";
        ResultSet resultSet = QueryExecutor.executeQuery(query, minMoviesCount);

        System.out.println("Actors in at least " + minMoviesCount + " movies:");
        while (resultSet.next()) {
            String actorFullName = resultSet.getString("full_name");
            int moviesCount = resultSet.getInt("movies_count");
            System.out.println("Actor: " + actorFullName + ", Movies Count: " + moviesCount);
        }

        resultSet.close();
    }

    public static void printActorDirectors() throws SQLException, ClassNotFoundException {
        String query = "SELECT DISTINCT a.full_name FROM Actors a " +
                "JOIN MovieDirectors md ON a.id = md.director_id";
        ResultSet resultSet = QueryExecutor.executeQuery(query);

        System.out.println("Actors who are also directors:");
        while (resultSet.next()) {
            String actorFullName = resultSet.getString("full_name");
            System.out.println(actorFullName);
        }

        resultSet.close();
    }

    public static void deleteMoviesOlderThanYears(int years) throws SQLException, ClassNotFoundException {
        DataModifier.deleteMoviesOlderThanYears(years);
        System.out.println("Movies older than " + years + " years deleted.");
    }
}
