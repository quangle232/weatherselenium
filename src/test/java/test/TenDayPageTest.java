package test;

import com.ql.core.helper.JsonHelper;
import com.ql.core.helper.Utilities;
import data.provider.WeatherDay;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.TenDayPage;
import pages.TodayPage;

public class TenDayPageTest extends BaseTest{

    @Test(dataProvider = "weather_day", dataProviderClass = WeatherDay.class)
    public void verifyAndGetInformationOfTenDayWeather(String ignoreToday, String numberOfDay) throws Exception {
        TodayPage todayPage = new TodayPage();
        TenDayPage tenDayPage = new TenDayPage();
        todayPage.navigate();
        todayPage.navigateToTenDayPage();
        int days = Integer.parseInt(numberOfDay);
        boolean includeToday = Boolean.parseBoolean(ignoreToday);
        String ignore = "includeToday";
        if(includeToday){
            ignore = "excludeToday";
        }
        JSONArray weatherJson = tenDayPage.retrieveTenDayWeatherInformation(days, includeToday);
        String filePath = String.format("src/weather/weather_info_%s_%sdays_%s_%s_%s.json",
                                        this.configuration.getProperty("country"),
                                        numberOfDay,
                                        ignore,
                                        this.browserName,
                                        Utilities.getCurrentDateTimeSuffix());
        JsonHelper.exportJsonToFile(filePath, weatherJson);
        Assert.assertTrue(Utilities.isFileNotEmpty(filePath));
    }

}
