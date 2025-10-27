package org.rstqb.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface WebConfig extends Config {

    String selenoidUrl();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("false")
    String isRemote();

    @DefaultValue("140.0")
    String browserVersion();

    @DefaultValue("https://www.rstqb.org/ru")
    String baseUrl();

    String selenoidLogin();

    String selenoidPass();

    @DefaultValue("eager")
    String pageLoadStrategy();
}
