package com.jacoco.utils;

import java.util.HashMap;
import java.util.Map;


public class Tools {
    private static Map<Integer, String> namelist = new HashMap<Integer, String>();


    public static void loadName() {
        namelist.put(1, "王小波");
        namelist.put(2, "杨先生");
        namelist.put(3, "钱钟书");
        namelist.put(4, "白岩松");
        namelist.put(5, "柴静");


    }

    public static Map<Integer, String> getNamelist() {
        return namelist;
    }

    public static void setName(String name, int uid) throws Exception {
        namelist.put(uid, name);
    }

}
