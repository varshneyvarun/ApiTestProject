package com.assignment.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final Gson gson = new Gson();

    public static JsonObject getJsonObjectFromString(String jsonString) {
        JsonObject json = null;
        try {
            json = new Gson().fromJson(jsonString, JsonObject.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public static Object convertJsonToDTO(String json, String dtoClassName) {
        Object containerObject = null;
        try {
            containerObject = Class.forName(dtoClassName).newInstance();
            Assert.assertNotEquals(containerObject, null, "Failed to load the target class for Class Name: " + dtoClassName);
            containerObject = gson.fromJson(json, containerObject.getClass());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return containerObject;
    }

    public static JsonArray getJsonArrayFromString(String jsonString) {
        JsonArray json = null;
        try {
            json = new Gson().fromJson(jsonString, JsonArray.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public static List<String> getValueOfKeyFromJsonArray(String response, String key){
        List<String> valueList = new ArrayList<>();
        JsonArray jsonArray = JsonUtils.getJsonArrayFromString(response);

        for ( int k = 0 ; k < jsonArray.size() ; k++){
            valueList.add(String.valueOf(jsonArray.get(k).getAsJsonObject().get(key)));
        }
        return valueList;
    }
}
