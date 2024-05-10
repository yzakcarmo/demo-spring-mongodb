package com.yzak.spring_mongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

    public static String decodeParam(String text) {
        return  URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static LocalDateTime convertDateTime(String date, LocalDateTime defaultValue) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            return LocalDateTime.parse(date, fmt);
        } catch (DateTimeParseException e) {
            return defaultValue;
        }
    }
}
