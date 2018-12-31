package com.sidekick.rest.client;

import java.util.HashMap;
import java.util.Map;

public class HttpArgs {

    private Map<String, String> headers;
    private Map<String, Object> query;
    private Object body;
    private String url;

    public HttpArgs() {
        headers = new HashMap<>();
        query = new HashMap<>();
        body = new Object();
        url = "";
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getQuery() {
        return query;
    }

    public void setQuery(Map<String, Object> query) {
        this.query = query;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpArgs withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    public HttpArgs withHeaders(Map<String, String> headers) {
        this.setHeaders(headers);
        return this;
    }

    public HttpArgs withQuery(Map<String, Object> query) {
        this.setQuery(query);
        return this;
    }

    public HttpArgs withBody(Object body) {
        this.setBody(body);
        return this;
    }
}
