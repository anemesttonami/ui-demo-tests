package org.rstqb.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${isRemote}.properties"})
public interface WebConfig extends Config {

    @DefaultValue("https://%s:%s@selenoid.autotests.cloud/wd/hub")
    String selenoidUrl();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("false")
    String isRemote();

    @DefaultValue("140.0")
    @Key("browserVersion")
    String browserVersion();

    @DefaultValue("https://www.rstqb.org/ru")
    String baseUrl();

    String selenoidLogin();

    String selenoidPass();
}
