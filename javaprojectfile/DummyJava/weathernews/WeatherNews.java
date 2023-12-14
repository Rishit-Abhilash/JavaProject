package weathernews;

public class WeatherNews {
    private String[] headlines;

    public WeatherNews() {
        headlines = new String[8];
        headlines[0] = "Heavy Rains To Continue In Kerala, Orange Alert In 3 Districts: Weather Office";
        headlines[1] = "Delhi's RWAs Ban Trash Burning, Issue Advisories Amid Poor Air-Quality";
        headlines[2] = "Weather Office Predicts Warmer November Amid Strong 'El Nino' Conditions";
        headlines[3] = "Delhi Air Quality 'Severe', Pollution May Spike Over Next 2 Weeks";
        headlines[4] = "Himachal Pradesh To Receive Rain, Snow After October 31, Says Weather Office";
        headlines[5] = "Anti-Smog Guns, Sprinklers To Fight Air Pollution In Mumbai";
        headlines[6] = "Low-Pressure System In Arabian Sea Set To Intensify Into Cyclonic Storm 'Tej'";
        headlines[7] = "Weather hits kharif supply, onion retails at Rs 80 per kg";
    }

    public void fetchWeatherNews() {
        // Display the weather news headlines
        System.out.println();
        System.out.println("Fetching and displaying weather news...");
        for (int i = 0; i < headlines.length; i++) {
            System.out.println((i + 1) + ". " + headlines[i]);
        }
    }
}