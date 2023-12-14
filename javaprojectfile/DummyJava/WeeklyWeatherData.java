package WWD;



public class WeeklyWeatherData implements WeeklyWeatherDataProvider 
{
    private final int[] temperatures;
    private final int[] humidities;
    private final String[] conditions;

    public WeeklyWeatherData(int[] temperatures, int[] humidities, String[] conditions) {
        this.temperatures = temperatures;
        this.humidities = humidities;
        this.conditions = conditions;
    }
    @Override
    public int[] getTemperatures() {
        return temperatures;
    }
    @Override
    public int[] getHumidities() {
        return humidities;
    }
    @Override
    public String[] getConditions() {
        return conditions;
    }

    public static class AhmedabadWeather extends WeeklyWeatherData implements WeeklyWeatherDataProvider {
        public AhmedabadWeather() {
            super(new int[]{32, 33, 34, 35, 33, 31, 30},
                    new int[]{65, 70, 68, 72, 67, 64, 66},
                    new String[]{"Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀"});
        }
    
        @Override
        public int[] getTemperatures() {
            return super.getTemperatures();
        }
    
        @Override
        public int[] getHumidities() {
            return super.getHumidities();
        }
    
        @Override
        public String[] getConditions() {
            return super.getConditions();
        }
    }

    }

    public static class PuneWeather extends WeeklyWeatherData {
        public PuneWeather() {
            super(new int[]{28, 29, 27, 30, 28, 31, 29},
                    new int[]{72, 76, 73, 70, 75, 71, 74},
                    new String[]{"Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀", "Partly Cloudy 🌤", "Sunny ☀", "Rainy 🌧", "Sunny ☀"});
        }
    }

    public static class MumbaiWeather extends WeeklyWeatherData {
        public MumbaiWeather() {
            super(new int[]{30, 32, 31, 29, 28, 30, 29},
                    new int[]{75, 70, 80, 72, 73, 77, 74},
                    new String[]{"Sunny ☀", "Cloudy ☁", "Rainy 🌧", "Sunny ☀", "Thunderstorm ⛈", "Rainy 🌧", "Sunny ☀"});
        }
    }

    public static class DelhiWeather extends WeeklyWeatherData {
        public DelhiWeather() {
            super(new int[]{25, 28, 27, 30, 29, 28, 26},
                    new int[]{60, 65, 70, 55, 58, 63, 62},
                    new String[]{"Sunny ☀", "Partly Cloudy 🌤", "Cloudy ☁", "Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀"});
        }
    }

    public static class BengaluruWeather extends WeeklyWeatherData {
        public BengaluruWeather() {
            super(new int[]{28, 27, 26, 29, 30, 28, 27},
                    new int[]{75, 80, 78, 70, 72, 76, 74},
                    new String[]{"Partly Cloudy 🌤", "Cloudy ☁", "Rainy 🌧", "Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀"});
        }
    }

    public static class ChennaiWeather extends WeeklyWeatherData {
        public ChennaiWeather() {
            super(new int[]{31, 33, 32, 34, 35, 32, 30},
                    new int[]{70, 75, 72, 68, 67, 71, 69},
                    new String[]{"Sunny ☀", "Partly Cloudy 🌤", "Cloudy ☁", "Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀"});
        }
    }

    public static class HyderabadWeather extends WeeklyWeatherData {
        public HyderabadWeather() {
            super(new int[]{33, 34, 35, 32, 30, 31, 33},
                    new int[]{65, 70, 68, 72, 75, 71, 68},
                    new String[]{"Sunny ☀", "Partly Cloudy 🌤", "Sunny ☀", "Rainy 🌧", "Cloudy ☁", "Sunny ☀", "Partly Cloudy 🌤"});
        }
    }

    public static class JaipurWeather extends WeeklyWeatherData {
        public JaipurWeather() {
            super(new int[]{27, 30, 29, 28, 31, 30, 26},
                    new int[]{55, 60, 58, 57, 62, 59, 56},
                    new String[]{"Sunny ☀", "Partly Cloudy 🌤", "Cloudy ☁", "Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀"});
        }
    }

    public static class KolkataWeather extends WeeklyWeatherData {
        public KolkataWeather() {
            super(new int[]{28, 29, 30, 31, 29, 27, 28},
                    new int[]{78, 75, 80, 72, 74, 76, 73},
                    new String[]{"Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀"});
        }
    }

    public static class LucknowWeather extends WeeklyWeatherData {
        public LucknowWeather() {
            super(new int[]{28, 29, 30, 31, 30, 28, 27},
                    new int[]{75, 78, 80, 72, 76, 73, 74},
                    new String[]{"Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀", "Partly Cloudy 🌤", "Rainy 🌧", "Sunny ☀"});
        }
    }
}

