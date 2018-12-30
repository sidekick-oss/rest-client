package com.sidekick.rest.client.util;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;

import java.io.IOException;

public class Json {

    public static String toJson(Object object) {
        return JsonStream.serialize(object);
    }

    public static Object fromJson(String json) {
        try {
            return JsonIterator.parse(json).read();
        } catch (IOException e) {
            // Swallow the exception, just leave the field null.
            return null;
        }
    }
}
