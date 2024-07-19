package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final String CONFIGFILEPATH = "config.properties";
    private static Properties properties = new Properties();

    static {
        try {
            File file = new File(CONFIGFILEPATH);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (Exception e) {
            // Handle exception and optionally rethrow as a runtime exception
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }

    public Long getTimeout() {
        String timeout = getValue("timeout");
        return Long.parseLong(timeout);
    }
}
