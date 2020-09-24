package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigService {
    private static final Config defaultConfig = ConfigFactory.load();
    public static final GlobalConfig globalConfig = new GlobalConfig( defaultConfig.getConfig( "settings" ) );
}
