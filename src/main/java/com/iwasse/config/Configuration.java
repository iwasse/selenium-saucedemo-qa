package com.iwasse.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:general.properties"
})
public interface Configuration extends Config {

    @Key("baseUrl")
    String url();

    @Key("browser")
    String browser();

}
