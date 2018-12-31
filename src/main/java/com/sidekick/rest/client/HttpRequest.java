package com.sidekick.rest.client;

import com.sidekick.rest.client.util.Json;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.Util;

import java.util.Map;

public class HttpRequest {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static Request.Builder addBody(Request.Builder request, Object body, HttpMethod method) {
        RequestBody bodyRequest = body != null ? RequestBody.create(JSON, Json.toJson(body)) : Util.EMPTY_REQUEST;
        switch (method) {
            case GET:
                request.get();
                break;
            case POST:
                request.post(bodyRequest);
                break;
            case PUT:
                request.put(bodyRequest);
                break;
            case PATCH:
                request.patch(bodyRequest);
                break;
            case DELETE:
                request.delete(bodyRequest);
                break;
            default:
                request.get();
                break;
        }
        return request;
    }

    public static void addHeaders(Request.Builder request, Map<String, String> headers) {
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                request.addHeader(header.getKey(), header.getValue());
            }
        }
    }

    public static void addQueryParameters(HttpUrl.Builder httpUrl, Map<String, Object> query) {
        if (query != null && !query.isEmpty()) {
            for (Map.Entry<String, Object> param : query.entrySet()) {
                httpUrl.addQueryParameter(param.getKey(), param.getValue().toString());
            }
        }
    }
}

