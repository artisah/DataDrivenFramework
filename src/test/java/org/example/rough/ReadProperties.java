package org.example.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public static void readPropertiesFile() throws IOException {

        Properties prop = new Properties();

        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
        prop.load(fs);

        System.out.println(prop.getProperty("googleserachbar"));

    }

    public static void main(String[] args) throws IOException {

        ReadProperties.readPropertiesFile();


    }
}
