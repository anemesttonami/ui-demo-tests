package org.rstqb.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.rstqb.config.ProjectConfiguration;
import org.rstqb.config.WebDriverProvider;
import org.rstqb.utils.Attach;

public class BaseTest {

    private static final ProjectConfiguration projectConfiguration = new ProjectConfiguration(new WebDriverProvider().webConfig);

    @BeforeAll
    static void beforeAll() {
        projectConfiguration.webConfig();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void setAttachments() {
        Attach.screenshotAs("screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Attach.addVideo();

        WebDriverRunner.closeWebDriver();
    }
}