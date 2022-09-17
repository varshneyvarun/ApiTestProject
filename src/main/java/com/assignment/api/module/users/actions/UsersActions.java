package com.assignment.api.module.users.actions;

import com.assignment.api.core.*;
import com.assignment.api.module.users.request.CreateUsersRequestDTO;
import com.assignment.core.RestUrlMapper;

import java.util.List;

public class UsersActions {

    APIClient apiClient = new APIClient();

    public APIResponse addUsersViaAPIDTO(List<CreateUsersRequestDTO> createUsersDTOList) {
        APIRequestSpecification requestSpecification = new APIRequestSpecification()
                .addBaseUrl(RestUrlMapper.CREATE_USERS.getURLPath())
                .setContentType(ContentType.APPLICATION_JSON)
                .addContent(createUsersDTOList)
                .build();

        APIResponse response = apiClient.executeRequest(HttpMethod.POST, requestSpecification);

        return response;

    }

    public APIResponse updateUsersViaAPIDTO(CreateUsersRequestDTO createUsersRequestDTO ,
                                                       String username) {
        APIRequestSpecification requestSpecification = new APIRequestSpecification()
                .addBaseUrl(RestUrlMapper.GET_USER.getURLPath() + username)
                .setContentType(ContentType.APPLICATION_JSON)
                .addContent(createUsersRequestDTO)
                .build();

        APIResponse response = apiClient.executeRequest(HttpMethod.PUT, requestSpecification);

        return response;

    }

    public APIResponse getUserDetailsViaAPI(String username) {
        APIRequestSpecification requestSpecification = new APIRequestSpecification()
                .addBaseUrl(RestUrlMapper.GET_USER.getURLPath() + username)
                .setContentType(ContentType.APPLICATION_JSON)
                .build();

        APIResponse response = apiClient.executeRequest(HttpMethod.GET, requestSpecification);

        return response;

    }
}
