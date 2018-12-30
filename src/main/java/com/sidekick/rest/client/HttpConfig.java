package com.sidekick.rest.client;

public class HttpConfig {

    private int connectTimeout;
    private int writeTimeout;
    private int readTimeout;

    public HttpConfig() {
        this.connectTimeout = 10;
        this.readTimeout = 10;
        this.writeTimeout = 10;
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
}
