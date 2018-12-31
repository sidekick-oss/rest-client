package com.sidekick.rest.client;

import com.sidekick.rest.client.exception.HttpException;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.concurrent.TimeUnit;

import static com.sidekick.rest.client.HttpRequest.addQueryParameters;
import static com.sidekick.rest.client.HttpRequest.addHeaders;
import static com.sidekick.rest.client.HttpRequest.addBody;

public class HttpClient {

    private String baseUrl;
    private OkHttpClient client;

    public HttpClient() {
        HttpConfig config = new HttpConfig();
        init(config);
    }

    public HttpClient(HttpConfig config) {
        init(config);
    }

    public HttpResponse get(HttpArgs args) {
        return call(args, HttpMethod.GET);
    }

    public HttpResponse put(HttpArgs args) {
        return call(args, HttpMethod.PUT);
    }

    public HttpResponse patch(HttpArgs args) {
        return call(args, HttpMethod.PATCH);
    }

    public HttpResponse post(HttpArgs args) {
        return call(args, HttpMethod.POST);
    }

    public HttpResponse delete(HttpArgs args) {
        return call(args, HttpMethod.DELETE);
    }

    public void setBaseUrl(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("Missing \"url\" config value");
        }
        if (!url.endsWith("/")) {
            url += "/";
        }
        baseUrl = url;
    }

    protected HttpResponse call(HttpArgs args, HttpMethod method) {
        try {
            if (args == null) {
                args = new HttpArgs();
            }

            if (method == null) {
                method = HttpMethod.GET;
            }

            HttpUrl.Builder url = buildUrl(args.getUrl());

            addQueryParameters(url, args.getQuery());

            Request.Builder request = new Request.Builder().url(url.build());

            addHeaders(request, args.getHeaders());
            addBody(request, args.getBody(), method);

            Response response = client.newCall(request.build()).execute();

            return new HttpResponse(response);
        } catch (Exception ex) {
            throw new HttpException(ex);
        }
    }

    private HttpUrl.Builder buildUrl(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("Missing \"url\" value");
        }
        if (url.startsWith("/")) {
            url = url.substring(1);
        }
        HttpUrl parsed = HttpUrl.parse(baseUrl + url);
        if (parsed == null) {
            throw new IllegalArgumentException("Unexpected url: " + url);
        }
        return parsed.newBuilder();
    }

    private void init(HttpConfig config) {
        this.client = new OkHttpClient.Builder().connectTimeout(config.getConnectTimeout(), TimeUnit.SECONDS)
                .writeTimeout(config.getWriteTimeout(), TimeUnit.SECONDS)
                .readTimeout(config.getReadTimeout(), TimeUnit.SECONDS)
                .build();
        this.baseUrl = "";
    }
}
