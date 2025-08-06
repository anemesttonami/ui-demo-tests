package org.rstqb.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.rstqb.utils.Attach;

import java.util.Map;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        //общая настройка вебдрайвера
        Configuration.baseUrl = "https://www.rstqb.org/ru";
        Configuration.browserSize = "1980x1020";
        Configuration.pageLoadStrategy = "eager";

        //для подключения к selenoid
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        //активация работы видеозаписи
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        //активация логгирования selenide - для отображения в Allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void setAttachments() {
        Attach.screenshotAs("screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Attach.addVideo();
    }
}