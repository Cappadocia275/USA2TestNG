package com.usa.utilities;

import java.io.FileInputStream;
import java.util.Properties;
public class ConfigurationReader {
    static Properties properties;

    static {
        try {
            String path = "configuration.properties";
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        String deger = properties.getProperty(key);
        return deger;
    }
}
