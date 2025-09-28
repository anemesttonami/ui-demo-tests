package org.rstqb.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface WebConfig extends Config {

    @DefaultValue("https://%s:%s@selenoid.autotests.cloud/wd/hub")
    @Key("selenoidUrl")
    String selenoidUrl();

    @DefaultValue("chrome")
    @Key("browser")
    String browser();

    @DefaultValue("1920x1080")
    @Key("browserSize")
    String browserSize();

    @DefaultValue("false")
    @Key("isRemote")
    String isRemote();

    @DefaultValue("140.0")
    @Key("browserVersion")
    String browserVersion();

    @DefaultValue("https://www.rstqb.org/ru")
    @Key("baseUrl")
    String baseUrl();

    @Key("selenoidLogin")
    String selenoidLogin();

    @Key("selenoidPass")
    String selenoidPass();

    @DefaultValue("eager")
    @Key("pageLoadStrategy")
    String pageLoadStrategy();
}
