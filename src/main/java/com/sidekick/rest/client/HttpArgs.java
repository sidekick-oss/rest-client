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

    public HttpArgs(Map args) {
        super();
        init(args);
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

    @SuppressWarnings("unchecked")
    private void init(Map args) {
        Object headers = args.get("headers");
        Object query = args.get("query");
        Object body = args.get("body");
        Object url = args.get("url");

        if (headers != null) {
            this.setHeaders((Map<String, String>) headers);
        }
        if (query != null) {
            this.setQuery((Map<String, Object>) query);
        }
        if (body != null) {
            this.setBody(body);
        }
        if (url != null) {
            this.setUrl(url.toString());
        }
    }
}
