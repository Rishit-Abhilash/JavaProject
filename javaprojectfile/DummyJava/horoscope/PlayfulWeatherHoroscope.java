// File: PlayfulWeatherHoroscope.java
package horoscope;

import java.util.Random;

public class PlayfulWeatherHoroscope implements WeatherHoroscope {
    @Override
    public String generateHoroscope() {
        // Simulate generating a playful weather horoscope
        String[] horoscopes = {
                "A sunny day ahead! Embrace the sunshine and positive vibes.",
                "Expect some rain today. Time to cozy up with a good book.",
                "Cloudy skies, but opportunities will shine through. Stay optimistic!",
                "A mix of sun and clouds. Balance is the key to a harmonious day.",
                "Snow is coming! Get ready for a winter wonderland."
        };

        // Generate a random index for the horoscopes array
        int index = new Random().nextInt(horoscopes.length);

        // Return the generated horoscope
        return horoscopes[index];
    }
}
