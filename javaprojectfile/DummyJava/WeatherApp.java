import java.util.Random;
import java.util.Scanner;
import weathernews.WeatherNews;
import WWD.WeeklyWeatherData;
import WWD.WeeklyWeatherData.*;
import WWD.WeeklyWeatherData.AhmedabadWeather;
import WeatherGame.ComplexSunshineHarvest;
import horoscope.*;
import weather.HistoricalWeather;
import historicalweather.historic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//First Class
class CityWeather {
    private String city;
    private float temperature;
    private float humidity;
    private String conditions;

    public CityWeather(String city, int temperature, int humidity, String conditions) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.conditions = conditions;
    }
    public void displayWeeklyForecast() {
        System.out.println("Weekly Weather Forecast for " + city);
        // Implement the logic to display the weekly forecast here
        // You can fetch data from a weather API and display it
        System.out.println("Implement the logic to display the weekly forecast here.");
    }
    public void WeeklyWeatherData() {
        System.out.println("City: " + city);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Conditions: " + conditions);
    }
}

interface WeatherServiceInterface{
    void startTravelPlanner();
}

class WeatherService {
    public static void startTravelPlanner() {
        // Sample implementation - suggest travel destinations based on weather preferences
        System.out.println("Enter your preferred weather conditions (e.g., sunny, rainy, snowy): ");
        Scanner scanner = new Scanner(System.in);
        String weatherPreference = scanner.nextLine();

        // Display suggestions without database connectivity
        System.out.println("Travel Suggestions:");
        if (weatherPreference.equalsIgnoreCase("sunny")) {
            System.out.println("- Goa");
        } else if (weatherPreference.equalsIgnoreCase("rainy")) {
            System.out.println("- Coorg");
        } else if (weatherPreference.equalsIgnoreCase("snowy")) {
            System.out.println("- Gulmarg");
        } else {
            System.out.println("- No suggestions for the given weather preference");
        }
    }
}

// //Second CLass
class WeatherQuiz {
    public static void startQuiz() {
        // Sample quiz questions
        String[] questions = {
                "What is the capital of France?",
                "Which planet is known as the Red Planet?",
                "What is the freezing point of water in Celsius?"
        };

        String[] answers = {"Paris", "Mars", "0"};

        // Display quiz questions and get user answers
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            System.out.print("Your Answer: ");
            String userAnswer = scanner.nextLine();

            // Check user's answer
            if (userAnswer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + answers[i]);
            }
        }

        // Display quiz result
        System.out.println("Quiz Complete. Your Score: " + score + "/" + questions.length);
    }
}

class GameController {
    private int cropCount;
    private int totalScore;
    private int seeds;
    private int water;
    private int fertilizer;

    public GameController() {
        this.cropCount = 0;
        this.totalScore = 0;
        this.seeds = 10;
        this.water = 10;
        this.fertilizer = 5;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean isGameRunning = true;

        
        while (isGameRunning) {
            // Display game status
            System.out.println("--------------------------------------------------------------");
            System.out.println("| Menu                                                       |");
            System.out.println("--------------------------------------------------------------");
            System.out.println(  "| Seeds: " + seeds + "                                                  |");
            System.out.println(  "| Water: " + water + "                                                  |");
            System.out.println(  "| Fertilizer: " + fertilizer + "                                              |");
            System.out.println(  "| Total Crops Planted: " + cropCount + "                                     |");
            System.out.println(  "| Total Score: " + totalScore + "                                             |");
            System.out.println("--------------------------------------------------------------");

            // Display weather conditions
            int weather = random.nextInt(3); // 0: Sunny, 1: Cloudy, 2: Rainy
            String weatherString = getWeatherString(weather);
            System.out.println(  "| Weather: " + weatherString + "                                             |");
            System.out.println("--------------------------------------------------------------");

            // User input for actions
            System.out.print(    "| Choose Action:                                             |" +
                               "\n|      Plant      (P)     Harvest  (H)      Buy Seeds  (B)   |" +
                               "\n|   Sell Crops    (S)                      Water Crops (W)   |" +
                               "\n| Fertilize Crops (F)    Inventory (I)       Quit      (Q)   |" +
                               "\n--------------------------------------------------------------\n");
            char input = scanner.next().charAt(0);

            // Add cases for selling, watering, fertilizing, and quitting
            switch (input) {
                case 'P':
                case 'p':
                    // Plant a crop
                    if (seeds > 0) {
                        plantCrop(weather);
                        seeds--;
                    } else {
                        System.out.println("Out of seeds. Buy more from the market.");
                    }
                    break;

                case 'H':
                case 'h':
                    // Harvest crops
                    harvestCrops();
                    break;

                case 'B':
                case 'b':
                    // Buy seeds from the market
                    buySeedsFromMarket();
                    break;

                case 'S':
                case 's':
                    // Sell crops
                    sellCrops();
                    break;

                case 'W':
                case 'w':
                    // Water crops
                    waterCrops();
                    break;

                case 'F':
                case 'f':
                    // Fertilize crops
                    fertilizeCrops();
                    break;

                case 'I':
                case 'i':
                    displayInventory();
                    break;

                case 'Q':
                case 'q':
                    // Quit the game
                    System.out.println("Quitting the game. Thanks for playing!");
                    isGameRunning = false;
                    // System.exit(0);
                    break;

                default:
                    System.out.println("Invalid action. Please choose a valid action.");
            }

            // Wait for a short duration before the next round
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Clear console
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    // Implement methods for planting, harvesting, buying, selling, watering, fertilizing

    private String getWeatherString(int weather) {
        switch (weather) {
            case 0:
                return "Sunny";
            case 1:
                return "Cloudy";
            case 2:
                return "Rainy";
            default:
                return "Unknown";
        }
    }

    private void plantCrop(int weather) {
        // Placeholder implementation for planting a crop
        System.out.println("You planted a crop!");
        cropCount++;
        totalScore += calculateScore(weather);
    }

    private void harvestCrops() {
        // Placeholder implementation for harvesting crops
        System.out.println("You harvested crops!");
        cropCount = 0; // Reset the crop count
        totalScore += calculateScore(0); // Assume sunny weather for scoring
    }

    private void buySeedsFromMarket() {
        // Placeholder implementation for buying seeds from the market
        System.out.println("You bought seeds from the market!");
        seeds += 5; // Add 5 seeds to the inventory
    }

    private void sellCrops() {
        // Placeholder implementation for selling crops
        System.out.println("You sold crops!");
        totalScore += cropCount * calculateSellPrice();
        cropCount = 0; // Reset the crop count after selling
    }

    private void waterCrops() {
        // Placeholder implementation for watering crops
        System.out.println("You watered crops!");
        water--;
        // Add logic for improved crop growth with watering if needed
    }

    private void fertilizeCrops() {
        // Placeholder implementation for fertilizing crops
        System.out.println("You fertilized crops!");
        fertilizer--;
        // Add logic for improved crop growth with fertilizing if needed
    }

    private int calculateSellPrice() {
        // Placeholder implementation for calculating the selling price
        // You can customize this based on your game's economy and rules.
        return 5; // For example, selling each crop for 5 points.
    }

    // Additional method for displaying the player's inventory
    private void displayInventory() {
        System.out.println("Inventory: Seeds - " + seeds + ", Water - " + water + ", Fertilizer - " + fertilizer);
    }

    private int calculateScore(int weather) {
        // Placeholder implementation for calculating score based on weather
        return weather == 0 ? 10 : 5; // Higher score for sunny weather
    }
}



public class WeatherApp {
    
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbc";
    static final String USERNAME = "root";
    static final String PASSWORD = "10022005jdbc";




        public static WeeklyWeatherData getCityWeatherData(String city) {
            
        if (city.equalsIgnoreCase("Mumbai")) 
        {
             return new MumbaiWeather();
        }
        if (city.equalsIgnoreCase("Delhi")) 
        {
            return new DelhiWeather();
        } 
        else if (city.equalsIgnoreCase("Bengaluru")) 
        {
            return new BengaluruWeather();
        } 
        else if (city.equalsIgnoreCase("Chennai")) 
        {
            return new ChennaiWeather();
        }
        else if (city.equalsIgnoreCase("Kolkata")) 
        {
            return new KolkataWeather();
        } 
        else if (city.equalsIgnoreCase("Hyderabad")) 
        {
            return new HyderabadWeather();
        } 
        else if (city.equalsIgnoreCase("Pune")) {
            return new PuneWeather();
        } 
        else if (city.equalsIgnoreCase("Jaipur")) {
            return new JaipurWeather();
        } 
        else if (city.equalsIgnoreCase("Ahmedabad")) {
            return new AhmedabadWeather();
        } 
        else if (city.equalsIgnoreCase("Lucknow")) {
            return new LucknowWeather();
        }
        else 
        {
            // Handle the case where the city is not recognized
            System.out.println("City not found in the database.");
            return null;
        } 
        }
    
    public static void main (String[]args){
       

            Scanner scanner = new Scanner(System.in);
            String[] cities = {"Mumbai", "Delhi", "Bengaluru", "Chennai", "Kolkata", "Hyderabad", "Pune", "Jaipur", "Ahmedabad", "Lucknow"};
            int[] temperatures = {25, 30, 28, 34, 31, 33, 29, 36, 30, 29};
            int[] humidities = {72, 45, 70, 55, 75, 50, 65, 40, 55, 70};
            String[] conditions = {"Sunny ☀ ", "Thunderstorm ⛈ ", "Rainy 🌧 ", "Hail 🌧 ", "Cloudy ☁ ", "Sunny ☀ ", "Snow ❄ ", "Sunny ☀ ", "Rainy 🌧 ", "Thunderstorm ⛈ "};

            while (true) {
                    System.out.println("╔════════════════════════════╗");
                    System.out.println("║      Weather App Menu      ║");
                    System.out.println("╠════════════════════════════╣");
                    System.out.println("║ 1. Select a city           ║");
                    System.out.println("║ 2. Weather quiz            ║");
                    System.out.println("║ 3. Virtual travel planner  ║");
                    System.out.println("║ 4. Weather Game            ║");
                    System.out.println("║ 5. Horoscope               ║");
                    System.out.println("║ 6. Historical weather      ║");
                    System.out.println("║ 7. Exit                    ║");
                    System.out.println("╚════════════════════════════╝");
        
                    // Additional features
                   
                    System.out.print("\nEnter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (choice == 1) {
                    System.out.println("Select a city:");
                    for (int i = 0; i < cities.length; i++) {
                        System.out.println((i + 1) + ". " + cities[i]);
                    }
                    System.out.print("Enter the city number: ");
                    int cityNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (cityNumber >= 1 && cityNumber <= cities.length) {
                        int index = cityNumber - 1;
                        System.out.println("City: " + cities[index]);
                        System.out.println("Temperature: " + temperatures[index] + "°C");
                        System.out.println("Humidity: " + humidities[index] + "%");
                        System.out.println("Conditions: " + conditions[index]);

                        // Ask if the user wants the weekly forecast
                        System.out.print("Do you want to know the weekly weather prediction for " + cities[index] + " (yes/no)? ");
                        String weeklyForecastChoice = scanner.nextLine().toLowerCase();

                        if (weeklyForecastChoice.equals("yes")) {
                            WeeklyWeatherData cityWeatherData = getCityWeatherData(cities[index]);
                            if (cityWeatherData != null) {
                                System.out.println("Weekly Weather Details for " + cities[index] + ":");
                                for (int day = 0; day < 7; day++) {
                                    System.out.println("Day " + (day + 1) + ":");
                                    System.out.println("Temperature: " + cityWeatherData.getTemperatures()[day] + "°C");
                                    System.out.println("Humidity: " + cityWeatherData.getHumidities()[day] + "%");
                                    System.out.println("Condition: " + cityWeatherData.getConditions()[day]);
                                    System.out.println();
                                }
                            } else {
                                System.out.println("City weather data not found.");
                            }
                        } else {
                            System.out.println("Weekly forecast not requested.");
                        }
                    }
                    }
                            else if (choice == 2) {
            WeatherQuiz.startQuiz();
        } else if (choice == 3) {
            WeatherService.startTravelPlanner();
        } else if (choice == 4) {
            GameController gameController = new GameController();
            gameController.startGame();
        } else if (choice == 5) {
            System.out.print("Do you want to view weather horoscope (yes/no)? ");
            String horoscopeChoice = scanner.nextLine().toLowerCase();

            if (horoscopeChoice.equals("yes")) {
                WeatherHoroscope weatherHoroscope = new PlayfulWeatherHoroscope();
                String horoscope = weatherHoroscope.generateHoroscope();
                System.out.println("Weather Horoscope: " + horoscope);
            }
        } else if (choice == 6) {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                historic.getHistoricalWeatherTrends(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (choice == 7) {
            System.out.print("Do you want to view weather news (yes/no)? ");
            String newsChoice = scanner.nextLine().toLowerCase();

            if (newsChoice.equals("yes")) {
                WeatherNews weatherNews = new WeatherNews();
                weatherNews.fetchWeatherNews();
            }
            System.out.println();
            System.out.println("Exiting the Weather App. Goodbye!");
            break;
        } else {
            System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}
}
       




