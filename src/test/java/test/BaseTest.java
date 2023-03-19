package test;

import com.ql.core.configuration.Configuration;
import com.ql.core.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

    public Configuration configuration;
    public String browserName;
    @BeforeMethod
    public void setUp() throws Exception {
        configuration = new Configuration("app.properties");
        DriverFactory.startDriver(this.getBrowserName());
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getDriver().quit();
    }

    public String getBrowserName() throws IOException {
        this.browserName = System.getProperty("browser");
        if(this.browserName != null){
            if(!this.browserName.isEmpty() || !this.browserName.isBlank()){
                return this.browserName;
            }

        }
        this.browserName = this.configuration.getProperty("browser");
        return this.browserName;
    }
}
