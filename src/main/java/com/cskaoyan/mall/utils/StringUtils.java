package com.cskaoyan.mall.utils;

public class StringUtils {
    public static boolean isEmpty(String s){
        if (s == null || "".equals(s)){
            return true;
        }else return false;
    }
}
