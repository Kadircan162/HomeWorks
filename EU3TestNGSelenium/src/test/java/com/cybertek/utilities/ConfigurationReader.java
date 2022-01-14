package com.cybertek.utilities;
/*
reads the properties file 'configuration.properties' which works as a data control center
*/

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        try {
            //what file to read
            String path = "configuration.properties";
            //Searches and finds the file using string path that we define and reads the file into java
            FileInputStream input = new FileInputStream(path);
            //Properties --> a class that store properties in key / value format
            properties = new Properties();
            //the values from the file input is loaded / fed in to the properties object
            properties.load(input);

            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String get(String keyName){
        return properties.getProperty(keyName);
    }

}
