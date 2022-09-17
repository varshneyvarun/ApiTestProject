package com.assignment.api.core;

import java.util.Map;

public class APIRequestSpecification {


    private String contentType;
    private String baseUrl;
    private String content;
    private Map<String, String> headers;
    private Map<String, Object> queryParams;
    private Object contentObj;
    private Map<String , String> cookies;

    public APIRequestSpecification setContentType(ContentType contentType){
        this.contentType = contentType.toString();
        return this;
    }

    public String getContentType(){
        return contentType;
    }

    public APIRequestSpecification addBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
        return this;
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public APIRequestSpecification addContent(String content){
        this.content = content;
        return this;
    }

    public APIRequestSpecification addContent(Object content){
        this.contentObj = content;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Object getContentObj() {
        return contentObj;
    }

    public Map<String, String> getHeaders(){
        return headers;
    }

    public Map<String, Object> getQueryParams(){
        return queryParams;
    }

    public APIRequestSpecification addCookies(Map<String , String> cookies){
        this.cookies = cookies;
        return this;
    }

    public Map<String , String> getCookies(){
        return cookies;
    }

    public APIRequestSpecification build(){
        return this;
    }
    
    
}
