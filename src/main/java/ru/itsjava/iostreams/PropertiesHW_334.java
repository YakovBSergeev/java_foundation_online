package ru.itsjava.iostreams;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHW_334 {
    public static void main(String[] args) {
        ClassLoader classLoader = PropertiesHW_334.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream( "app.properties" )) {
            Properties propertiesAsStream = new Properties();
            propertiesAsStream.load( inputStream );
            System.out.println( propertiesAsStream.getProperty( "key1" ) );
            System.out.println( propertiesAsStream.getProperty( "key2" ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
