package com.yzak.spring_mongo.resources.util;

import com.mongodb.client.model.ReturnDocument;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String decodeParam(String text) {
        //return URLDecoder.decode(text, StandardCharsets.UTF_8);
        try {
            return  URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
