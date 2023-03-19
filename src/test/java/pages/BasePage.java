package pages;

import com.ql.core.configuration.Configuration;
import com.ql.core.driver.DriverFactory;
import com.ql.core.keyword.WebActionKeyword;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.component.NavigatorTab;

import java.io.IOException;

@Getter
public class BasePage {

    public WebDriver _driver;
    public String _url;
    public WebActionKeyword _actionKeyword;
    public NavigatorTab navigatorTab;
    public Configuration configuration;
    public BasePage() throws IOException {
        this.configuration = new Configuration("app.properties");
        this._driver = DriverFactory.getDriver();
        this._url = this.configuration.getUrl();
        this._actionKeyword = new WebActionKeyword(this._driver);
        this.navigatorTab = new NavigatorTab(this._driver);
    }

    // start general page elements section

    // end general page elements section

    // start general page actions section
    public void navigate() throws Exception {
        this._actionKeyword.openUrl(this._url);
    }

    public void navigateToTenDayPage() {
        this.getNavigatorTab().navigateToTenDayPage();
    }

    // end general page actions section

    // start general page validation section

    // end general page validation section
}
