package com.assignment.core;

import static com.assignment.lib.base.BaseConfig.getBaseUrl;

public enum RestUrlMapper {


    CREATE_USERS("/v2/user/createWithArray"),
    GET_USER("/v2/user/"),
    CREATE_PET("/v2/pet"),
    GET_PET_STATUS("/v2/pet/findByStatus?status=")
    ;

    private final String URLPath;

    RestUrlMapper(String s) {
        this.URLPath = s;
    }

    public String getURLPath() {
        return getApiBaseUrl() + this.URLPath;
    }

    public String getApiBaseUrl() {
        return getBaseUrl();
    }



}
