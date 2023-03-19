package pages.component;

import com.ql.core.keyword.WebActionKeyword;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

@Getter
public class NavigatorTab{

    public WebDriver _driver;
    public WebActionKeyword _actionKeyword;
    public NavigatorTab(WebDriver driver) {
        this._driver = driver;
        this._actionKeyword = new WebActionKeyword(this._driver);
    }

    // start component elements section

    // end component elements section

    // start component actions section
    public WebElement getTabByText(String text){
        return this._actionKeyword.findElement(By.xpath(String.format("//*[text() = '%s']", text)));
    }
    public void navigateToTenDayPage(){
        _actionKeyword.click(this.getTabByText("10 Day"));
    }
    // end component actions section

    // start component validation section
    // end component validation section
}
