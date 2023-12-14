package historicalweather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class historic {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbc";
    static final String USERNAME = "root";
    static final String PASSWORD = "10022005jdbc";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            displayMenu(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayMenu(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Get Current Weather");
            System.out.println("2. Historical Weather Trends");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getCurrentWeather(connection);
                    break;
                case 2:
                    getHistoricalWeatherTrends(connection);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void getCurrentWeather(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city to retrieve current weather data: ");
        String city = scanner.nextLine();

        // Implement code to fetch and display current weather details for the specified city from the database
        try {
            String query = "SELECT * FROM 'weather_data' WHERE 'city' = ?";
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




























































