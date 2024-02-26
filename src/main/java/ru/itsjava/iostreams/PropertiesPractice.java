package ru.itsjava.iostreams;

import java.io.*;
import java.util.Properties;

public class PropertiesPractice {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/application.properties");

        Properties props = new Properties();
        props.load(new FileInputStream(file));

        System.out.println("props.getProperty(\"key1\") = " + props.getProperty("key1"));

        props.setProperty("key2", "value2");

        System.out.println("props.getProperty(\"key2\") = " + props.getProperty("key2"));


        ClassLoader classLoader = PropertiesPractice.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");

        Properties propsFromStream = new Properties();

        propsFromStream.load(inputStream);

        System.out.println("propsFromStream.getProperty(\"key1\") = " + propsFromStream.getProperty("key1"));


    }
}
