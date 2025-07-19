import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherAPIClient {

    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=12.97&longitude=77.59&current_weather=true";

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(response.toString());
            JSONObject weather = json.getJSONObject("current_weather");

            System.out.println("Weather in Bangalore:");
            System.out.println("----------------------");
            System.out.println("Temperature: " + weather.getDouble("temperature") + " °C");
            System.out.println("Wind Speed : " + weather.getDouble("windspeed") + " km/h");
            System.out.println("Time       : " + weather.getString("time"));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
