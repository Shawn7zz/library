package com.lan.library.utils;

import java.util.Objects;

/**
 * @author Xiang Lan
 * Created on 2019-07-03 17:41
 */
public class StringUtils {

    public static String formatStringArray(String[] strings) {
        if (Objects.isNull(strings)) return "null";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i != strings.length - 1) {
                sb.append(strings[i]);
                sb.append(" ");
            } else {
                sb.append(strings[i]);
            }
        }
        return sb.toString();
    }
}
