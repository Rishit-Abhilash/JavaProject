// WeeklyWeatherDataProvider
public interface WeeklyWeatherDataProvider {
    int[] getTemperatures();
    int[] getHumidities();
    String[] getConditions();
}

