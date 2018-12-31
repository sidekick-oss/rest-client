package com.sidekick.rest.client;

import java.util.Map;

public class HttpConfig {

    private int connectTimeout;
    private int writeTimeout;
    private int readTimeout;

    public HttpConfig() {
        this.connectTimeout = 10;
        this.readTimeout = 10;
        this.writeTimeout = 10;
    }

    public HttpConfig(Map<String, Integer> config) {
        super();
        init(config);
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public HttpConfig withConnectTimeout(int connectTimeout) {
        this.setConnectTimeout(connectTimeout);
        return this;
    }

    public HttpConfig withReadTimeout(int readTimeout) {
        this.setReadTimeout(readTimeout);
        return this;
    }

    public HttpConfig withWriteTimeout(int writeTimeout) {
        this.setWriteTimeout(writeTimeout);
        return this;
    }

    private void init(Map<String, Integer> config) {
        Integer value = config.get("connectTimeout");
        if (value != null) {
            this.connectTimeout = value;
        }
        value = config.get("readTimeout");
        if (value != null) {
            this.readTimeout = value;
        }
        value = config.get("writeTimeout");
        if (value != null) {
            this.writeTimeout = value;
        }
    }
}
