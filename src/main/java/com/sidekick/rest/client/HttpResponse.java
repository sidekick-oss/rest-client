package com.sidekick.rest.client;

import com.sidekick.rest.client.util.Json;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class HttpResponse {

    private int code;
    private String message;
    private Object json;
    private String body;

    public HttpResponse(Response response) {
        this.code = response.code();
        this.message = response.message();
        this.body = bodyAsString(response.body());
        this.json = Json.fromJson(getBody());
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getJson() {
        return json;
    }

    public String getBody() {
        return body;
    }

    private String bodyAsString(ResponseBody body) {
        if (body != null) {
            try {
                return body.string();
            } catch (IOException e) {
                // Swallow the exception, just leave the field null.
                return null;
            }
        }
        return null;
    }

}
