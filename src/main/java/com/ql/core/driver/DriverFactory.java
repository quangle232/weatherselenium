package com.ql.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driverStore = new ThreadLocal<>();
    public static void startDriver(String browser){
        switch(browser){
            case "chrome":
                driverStore.set(initChromeDriver());
                break;
            case "firefox":
                driverStore.set(initFirefoxDriver());
                break;
            case "ie":
                //TODO : implement IE Desired Capabilities
                break;
        }
    }

    public static WebDriver getDriver(){
        return driverStore.get();
    }

    private static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--kiosk"); // This is specific for MacOS => window: --start-maximize
        return new ChromeDriver(options);
    }

    private static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        // TODO: add desired capabilities for firefox
        return new FirefoxDriver();
    }

}
