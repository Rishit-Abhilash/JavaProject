    package WWD;

public class WeeklyWeatherData {
   private final int[] temperatures;
   private final int[] humidities;
   private final String[] conditions;

   public WeeklyWeatherData(int[] var1, int[] var2, String[] var3) {
      this.temperatures = var1;
      this.humidities = var2;
      this.conditions = var3;
   }

   public int[] getTemperatures() {
      return this.temperatures;
   }

   public int[] getHumidities() {
      return this.humidities;
   }

   public String[] getConditions() {
      return this.conditions;
   }
}
    