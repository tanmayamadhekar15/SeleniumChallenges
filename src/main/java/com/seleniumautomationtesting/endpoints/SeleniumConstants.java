package com.seleniumautomationtesting.endpoints;

import com.seleniumautomationtesting.utils.DynamicDataReaderUtil;

public class SeleniumConstants {

    //using file reader
    public static String BASE_URL;

    static {
        try {
            BASE_URL = DynamicDataReaderUtil.readAKey("url");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
