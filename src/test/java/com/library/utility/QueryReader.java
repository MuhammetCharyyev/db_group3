package com.library.utility;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class QueryReader {

    private static Properties properties = new Properties();


    static{
        try {
            FileInputStream file = new FileInputStream("src/test/resources/queries/queries.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Properties File not found");
        }
    }


    public static String read(String keyWord){
        return properties.getProperty(keyWord);
    }


}
