package config;

import com.typesafe.config.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalConfig {
    public final String baseUri;
    public final String imageUri;
    public String apiKey;

    public GlobalConfig( Config config ) {
        this.baseUri = config.getString( "baseUri" );
        this.imageUri = config.getString( "imageUri" );
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream( "my.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        this.apiKey = properties.getProperty("apiKey");
//        this.apiKey = config.getString( "apiKey" );

    }
}
