package com.assignment.api.core;

import com.assignment.utils.Log;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class APIClient {


    public APIResponse executeRequest(HttpMethod requestType, APIRequestSpecification requestSpecification){

        Log.info(requestSpecification.getBaseUrl());

        if (requestSpecification.getContentObj() != null) {
            if (requestSpecification.getContentType().equalsIgnoreCase(ContentType.APPLICATION_JSON.toString())) {
                String content;
                if (!(requestSpecification.getContentObj() instanceof String)) {
                    content = new Gson().toJson(requestSpecification.getContentObj());
                } else
                    content = (String) requestSpecification.getContentObj();

                requestSpecification.addContent(content);
            }
        }
        return baseRestImpl(requestType, requestSpecification.getBaseUrl() , requestSpecification.getCookies() ,
                requestSpecification.getHeaders(), requestSpecification.getQueryParams(),
                requestSpecification.getContentType(), requestSpecification.getContent());
    }

    private APIResponse baseRestImpl(HttpMethod requestType, String baseUrl, Map<String , String > cookies ,
                                     Map<String, String> headers, Map<String, Object> queryParams, String contentType,
                                     String content) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        RequestSpecification requestSpecification;
        Response response;

        if (cookies != null && !cookies.isEmpty())
            requestSpecBuilder.addCookies(cookies);
        if (headers != null && !headers.isEmpty())
            requestSpecBuilder.addHeaders(headers);
        if (queryParams != null && !queryParams.isEmpty())
            requestSpecBuilder.addQueryParams(queryParams);
        if (contentType != null)
            requestSpecBuilder.setContentType(contentType);
        if (content != null)
            requestSpecBuilder.setBody(content);

        requestSpecification = requestSpecBuilder.build();

        response = execute(baseUrl, requestType, requestSpecification);

        return processRestAssuredResponse(response);
    }
    private APIResponse processRestAssuredResponse(Response response){
        APIResponse testResponse = new APIResponse();
        if (response != null){

            if (response.getBody() != null)
                testResponse.setResponseBody(response.getBody().asString());

            testResponse.setStatusCode(response.getStatusCode());
            testResponse.setStatusLine(response.getStatusLine());
            testResponse.setCookies(response.getCookies());
            testResponse.setJsonPath(response.jsonPath());

            if (response.getHeaders() != null && response.getHeaders().size() > 0) {
                Map<String, String> responseHeaders = new HashMap<>();
                for (Header header : response.getHeaders())
                    responseHeaders.put(header.getName(), header.getValue());
                testResponse.setHeaders(responseHeaders);
            }
        }
        return testResponse;
    }

    private Response execute(String baseUrl , HttpMethod requestType, RequestSpecification requestSpecification){

        Response response = null;

        try {
            switch (requestType){
                case GET:
                    response = RestAssured.given().spec(requestSpecification).get(baseUrl);
                    break;
                case POST:
                    response = RestAssured.given().spec(requestSpecification).post(baseUrl);
                    break;
                case PUT:
                    response = RestAssured.given().spec(requestSpecification).put(baseUrl);
                    break;
                case PATCH:
                    response = RestAssured.given().spec(requestSpecification).patch(baseUrl);
                    break;
                case DELETE:
                    response = RestAssured.given().spec(requestSpecification).delete(baseUrl);
                    break;
            }
        }catch (Exception e){
            System.out.println("Exception for url : " + baseUrl);
            e.printStackTrace();
        }

        Log.info(String.valueOf(response.getStatusCode()));
        Log.info("***********");
        Log.info("***********");
        return response;
    }



}
