package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;

    static {
        try {
            FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read from config.properties file");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
