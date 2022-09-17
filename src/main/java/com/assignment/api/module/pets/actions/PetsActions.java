package com.assignment.api.module.pets.actions;

import com.assignment.api.core.*;
import com.assignment.api.module.pets.request.CreatePetsRequestDTO;
import com.assignment.core.RestUrlMapper;

import java.util.List;

public class PetsActions {


    APIClient apiClient = new APIClient();

    public APIResponse addPetViaAPIDTO(CreatePetsRequestDTO createPetsRequestDTO) {
        APIRequestSpecification requestSpecification = new APIRequestSpecification()
                .addBaseUrl(RestUrlMapper.CREATE_PET.getURLPath())
                .setContentType(ContentType.APPLICATION_JSON)
                .addContent(createPetsRequestDTO)
                .build();

        APIResponse response = apiClient.executeRequest(HttpMethod.POST, requestSpecification);

        return response;

    }

    public APIResponse getPetStatusViaAPI(String status) {
        APIRequestSpecification requestSpecification = new APIRequestSpecification()
                .addBaseUrl(RestUrlMapper.GET_PET_STATUS.getURLPath() + status)
                .setContentType(ContentType.APPLICATION_JSON)
                .build();

        APIResponse response = apiClient.executeRequest(HttpMethod.GET, requestSpecification);

        return response;

    }

    public APIResponse updatePetViaAPIDTO(CreatePetsRequestDTO createPetsRequestDTO) {
        APIRequestSpecification requestSpecification = new APIRequestSpecification()
                .addBaseUrl(RestUrlMapper.CREATE_PET.getURLPath())
                .setContentType(ContentType.APPLICATION_JSON)
                .addContent(createPetsRequestDTO)
                .build();

        APIResponse response = apiClient.executeRequest(HttpMethod.PUT, requestSpecification);

        return response;

    }
}
