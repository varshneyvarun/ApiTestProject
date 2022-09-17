package com.assignment.api.core;

import io.restassured.path.json.JsonPath;

import java.util.Map;

public class APIResponse {

    private String responseBody;
    private int statusCode;
    private Map<String, String> headers;
    private Map<String , String> cookies;

    private String statusLine;
    private JsonPath jsonPath;

    public String getResponseBody() {
        return responseBody;
    }

    public JsonPath getJsonPath(){
        return jsonPath;
    }

    public void setJsonPath(JsonPath jsonPath){
        this.jsonPath = jsonPath;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setCookies(Map<String , String> cookies){
        this.cookies = cookies;
    }

    public Map<String , String> getCookies(){
        return cookies;
    }

    public String getStatusLine(){
        return statusLine;
    }

    public void setStatusLine(String statusLine){
        this.statusLine = statusLine;
    }


}
