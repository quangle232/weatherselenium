package test;

import com.ql.core.helper.JsonHelper;
import com.ql.core.helper.Utilities;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.TenDayPage;
import pages.TodayPage;

public class TenDayPageTest extends BaseTest{

    @Test
    public void verifyAndGetInformationOfTenDayWeather() throws Exception {
        TodayPage todayPage = new TodayPage();
        TenDayPage tenDayPage = new TenDayPage();
        todayPage.navigate();
        todayPage.navigateToTenDayPage();
        JSONArray weatherJson = tenDayPage.retrieveTenDayWeatherInformation(10);
        String filePath = String.format("src/weather/weather_info_%s_%s_%s.json",
                                        this.configuration.getProperty("country"),
                                        this.browserName,
                                        Utilities.getCurrentDateTimeSuffix());
        JsonHelper.exportJsonToFile(filePath, weatherJson);
        Assert.assertTrue(Utilities.isFileNotEmpty(filePath));
    }

    @Test
    public void shouldBePassToTestSureFireReportOnly(){
        Assert.assertTrue(1==1);
    }

    @Test
    public void shouldBeFailedToTestSureFireReportOnly(){
        Assert.assertTrue(1==2);
    }
}
