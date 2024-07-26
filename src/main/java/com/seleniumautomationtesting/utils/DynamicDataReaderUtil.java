package com.seleniumautomationtesting.utils;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DynamicDataReaderUtil {
    //constructor
    public DynamicDataReaderUtil(){

    }
    //Method to get a key
    public static String readAKey(String key) throws Exception {
        FileInputStream fio=new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/com/seleniumautomationtesting/resources/DynamicData.properties"));
        Properties p=new Properties();
        p.load(fio);

        if(p.getProperty(key)==null){
            throw new Exception("Not able to find a key");
        }
        else{
            return p.getProperty(key);
        }

    }
}
