package data.provider;

import com.ql.core.helper.JsonHelper;
import org.testng.annotations.DataProvider;

public class WeatherDay {

    @DataProvider(name = "weather_day")
    public static Object[][] weatherDay(){
        return JsonHelper.ReadJsonFromFile("src/test/java/data/driven/weather-days.json");
    }
}
