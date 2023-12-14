// Create a new package named 'weather'
package historicalweather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Historical {

    // Method to fetch and display historical weather trends for a specified city
    public static void getHistoricalWeatherTrends(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city to retrieve historical weather data: ");
        String city = scanner.nextLine();

        // Implement code to fetch and display historical weather trends for the specified city from the database
        try {
            String query = "SELECT * FROM weather_data WHERE city = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, city);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("City: " + resultSet.getString("city") +
                            ", Temperature: " + resultSet.getDouble("temperature") +
                            ", Date: " + resultSet.getDate("date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}