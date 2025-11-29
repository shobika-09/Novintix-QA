package com.novintix.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    static {
        try {
            String env = System.getProperty("env", "local");
            String path = "src/test/resources/config/" + env + ".properties";
            InputStream in = new FileInputStream(path);
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config properties: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static int getInt(String key, int defaultVal) {
        String v = props.getProperty(key);
        return v == null ? defaultVal : Integer.parseInt(v);
    }

    public static boolean getBoolean(String key, boolean defaultVal) {
        String v = props.getProperty(key);
        return v == null ? defaultVal : Boolean.parseBoolean(v);
    }
}
