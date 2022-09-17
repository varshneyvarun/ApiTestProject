package com.assignment.api.core;

public enum ContentType {

    APPLICATION_JSON("application/json"),
    TEXT_PLAIN("text/plain;charset=utf-8"),
    TEXT_HTML("text/html")
    ;

    private final String contentType;

    ContentType(String contentType) {
        this.contentType = contentType;
    }

    public String toString() {
        return contentType;
    }
}
