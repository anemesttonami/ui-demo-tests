package org.rstqb.config;

import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

@Slf4j
public class ProjectConfiguration {
    private final WebConfig webConfig;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void webConfig() {
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser();
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = webConfig.browserSize();
        Configuration.browserVersion = webConfig.browserVersion();

        if (Boolean.parseBoolean(webConfig.isRemote())) {
            Configuration.remote = String.format(webConfig.selenoidUrl(), webConfig.selenoidLogin(), webConfig.selenoidPass());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
