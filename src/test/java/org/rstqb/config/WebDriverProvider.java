package org.rstqb.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    public final WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    @Override
    public WebDriver get() {
        String browser = webConfig.browser();

        if (browser.equalsIgnoreCase(Browser.CHROME.browserName())) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase(Browser.FIREFOX.browserName())) {
            WebDriverManager.operadriver().setup();
            return new FirefoxDriver();
        }

        throw new RuntimeException("No such browser");
    }
}
