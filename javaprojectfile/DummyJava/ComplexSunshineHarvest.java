package WeatherGame;

import java.util.Scanner;
import java.util.Random;

public class ComplexSunshineHarvest {
    private static int cropCount = 0;
    private static int totalScore = 0;
    private static int seeds = 10;
    private static int water = 10;
    private static int fertilizer = 5;

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            // Display game status
            System.out.println("--------------------------------------------");
            System.out.println("| Menu                                  |");
            System.out.println("--------------------------------------------");
            System.out.println("| Seeds: " + seeds + "                             |");
            System.out.println("| Water: " + water + "                             |");
            System.out.println("| Fertilizer: " + fertilizer + "                   |");
            System.out.println("| Total Crops Planted: " + cropCount + "           |");
            System.out.println("| Total Score: " + totalScore + "                  |");
            System.out.println("--------------------------------------------");

            // Display weather conditions
            int weather = random.nextInt(3); // 0: Sunny, 1: Cloudy, 2: Rainy
            String weatherString = getWeatherString(weather);
            System.out.println("| Weather: " + weatherString + "                           |");
            System.out.println("--------------------------------------------");

            // User input for actions
            System.out.print("| Choose Action:                           |" +
                    "\n| (P)lant  (H)arvest  (B)uy Seeds        |" +
                    "\n| (S)ell Crops  (W)ater Crops            |" +
                    "\n| (F)ertilize Crops  (I)nventory  (Q)uit |" +
                    "\n--------------------------------------------\n");
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
                    System.exit(0);
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

    private static String getWeatherString(int weather) {
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

    private static void plantCrop(int weather) {
        // Placeholder implementation for planting a crop
        System.out.println("You planted a crop!");
        cropCount++;
        totalScore += calculateScore(weather);
    }

    private static void harvestCrops() {
        // Placeholder implementation for harvesting crops
        System.out.println("You harvested crops!");
        cropCount = 0; // Reset the crop count
        totalScore += calculateScore(0); // Assume sunny weather for scoring
    }

    private static void buySeedsFromMarket() {
        // Placeholder implementation for buying seeds from the market
        System.out.println("You bought seeds from the market!");
        seeds += 5; // Add 5 seeds to the inventory
    }

    private static void sellCrops() {
        // Placeholder implementation for selling crops
        System.out.println("You sold crops!");
        totalScore += cropCount * calculateSellPrice();
        cropCount = 0; // Reset the crop count after selling
    }

    private static void waterCrops() {
        // Placeholder implementation for watering crops
        System.out.println("You watered crops!");
        water--;
        // Add logic for improved crop growth with watering if needed
    }

    private static void fertilizeCrops() {
        // Placeholder implementation for fertilizing crops
        System.out.println("You fertilized crops!");
        fertilizer--;
        // Add logic for improved crop growth with fertilizing if needed
    }

    private static int calculateSellPrice() {
        // Placeholder implementation for calculating the selling price
        // You can customize this based on your game's economy and rules.
        return 5; // For example, selling each crop for 5 points.
    }

    // Additional method for displaying the player's inventory
    private static void displayInventory() {
        System.out.println("Inventory: Seeds - " + seeds + ", Water - " + water + ", Fertilizer - " + fertilizer);
    }

    private static int calculateScore(int weather) {
        // Placeholder implementation for calculating score based on weather
        return weather == 0 ? 10 : 5; // Higher score for sunny weather
    }
}
