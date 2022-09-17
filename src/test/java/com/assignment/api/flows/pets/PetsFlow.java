package com.assignment.api.flows.pets;

import com.assignment.api.core.APIResponse;
import com.assignment.api.module.pets.actions.PetsActions;
import com.assignment.api.module.pets.request.Category;
import com.assignment.api.module.pets.request.CreatePetsRequestDTO;
import com.assignment.api.module.pets.request.Tag;
import com.assignment.api.module.pets.response.CreatePetsResponseDTO;
import com.assignment.utils.JsonUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.lib.support.TestData.*;
import static com.assignment.lib.support.TestData.getTagIdValue;
import static java.util.Arrays.asList;

public class PetsFlow {

    public void addAndVerifyPet(){


        PetsActions petsActions = new PetsActions();

        int tagID1 = getTagIdValue() ;
        int tagID2 = getTagIdValue() ;
        int categoryId = getTagIdValue();
        int petId = getTagIdValue();

        String tagName1 = getAutoTagName() ;
        String tagName2 = getAutoTagName() ;
        String categoryName = getAutoCategoryName();
        String petName = getAutoPetName();
        String status = "available";
        String photoUrl1 = "123.jpg";
        String photoUrl2 = "456.jpg";

        List<Tag> tagList = new ArrayList<>();

        Tag tag1 = new Tag();
        tag1.setId(tagID1).setName(tagName1);

        Tag tag2 = new Tag();
        tag2.setId(tagID2).setName(tagName2);

        tagList.addAll(asList(tag1 , tag2));

        Category category = new Category();

        category.setId(categoryId).setName(categoryName);

        CreatePetsRequestDTO createPetsRequestDTO = new CreatePetsRequestDTO();

        createPetsRequestDTO.setId(petId).setCategory(category).setName(petName).setPhotoUrls(asList(photoUrl1,photoUrl2))
                .setTags(tagList).setStatus(status);

        APIResponse response = petsActions.addPetViaAPIDTO(createPetsRequestDTO);

        CreatePetsResponseDTO createPetsResponseDTO = (CreatePetsResponseDTO) JsonUtils.convertJsonToDTO(
                response.getResponseBody(), CreatePetsResponseDTO.class.getCanonicalName());

        Assert.assertEquals(response.getStatusCode() , 200 , "Incorrect status code is shown");
        Assert.assertEquals(createPetsResponseDTO.getId() , petId ,"Incorrect Pet Id is shown" );
        Assert.assertEquals(createPetsResponseDTO.getName() , petName , "Incorrect Pet Name is shown");
        Assert.assertEquals(createPetsResponseDTO.getStatus() , status , "Incorrect Pet Status is shown");
        Assert.assertEquals(createPetsResponseDTO.getTags().get(0).getId() , tagID1 ,
                "Incorrect Tag Id is shown");
        Assert.assertEquals(createPetsResponseDTO.getTags().get(0).getName() , tagName1 ,
                "Incorrect Tag Name is shown");
        Assert.assertEquals(createPetsResponseDTO.getTags().get(1).getId() , tagID2 ,
                "Incorrect Tag Id is shown");
        Assert.assertEquals(createPetsResponseDTO.getTags().get(1).getName() , tagName2 ,
                "Incorrect Tag Name is shown");
        Assert.assertEquals(createPetsResponseDTO.getCategory().getId() , categoryId ,
                "Incorrect Category Id is shown");
        Assert.assertEquals(createPetsResponseDTO.getCategory().getName() , categoryName ,
                "Incorrect Category Name is shown");
        Assert.assertEquals(createPetsResponseDTO.getPhotoUrls().get(0) , photoUrl1 ,
                "Incorrect Photo Url is shown");
        Assert.assertEquals(createPetsResponseDTO.getPhotoUrls().get(1) , photoUrl2 ,
                "Incorrect Photo Url is shown");

    }

    public void verifyPertDetailsByStatus(String status){

        PetsActions petsActions = new PetsActions();
        APIResponse response = petsActions.getPetStatusViaAPI(status);
        Assert.assertEquals(response.getStatusCode() , 200 , "Incorrect status code is shown");
        List<String> statusList = JsonUtils.getValueOfKeyFromJsonArray(response.getResponseBody() , "status");
        for (String statusType : statusList){
            Assert.assertEquals(statusType , "\"" + status + "\"" , "Incorrect status is shown");
        }

    }

    public void updateAndVerifyPertDetails(){

        PetsActions petsActions = new PetsActions();

        int tagID1 = getTagIdValue() ;
        int tagID2 = getTagIdValue() ;
        int categoryId = getTagIdValue();
        int petId = getTagIdValue();

        String tagName1 = getAutoTagName() ;
        String tagName2 = getAutoTagName() ;
        String categoryName = getAutoCategoryName();
        String petName = getAutoPetName();
        String status = "available";
        String updateStatus = "sold";
        String photoUrl1 = "123.jpg";
        String photoUrl2 = "456.jpg";

        List<Tag> tagList = new ArrayList<>();

        Tag tag1 = new Tag();
        tag1.setId(tagID1).setName(tagName1);

        Tag tag2 = new Tag();
        tag2.setId(tagID2).setName(tagName2);

        tagList.addAll(asList(tag1 , tag2));

        Category category = new Category();

        category.setId(categoryId).setName(categoryName);

        CreatePetsRequestDTO createPetsRequestDTO1 = new CreatePetsRequestDTO();

        createPetsRequestDTO1.setId(petId).setCategory(category).setName(petName).setPhotoUrls(asList(photoUrl1,photoUrl2))
                .setTags(tagList).setStatus(status);

        petsActions.addPetViaAPIDTO(createPetsRequestDTO1);

        CreatePetsRequestDTO createPetsRequestDTO2 = new CreatePetsRequestDTO();


        createPetsRequestDTO2.setId(petId).setCategory(category).setName(petName).setPhotoUrls(asList(photoUrl1,photoUrl2))
                .setTags(tagList).setStatus(updateStatus);

        APIResponse response = petsActions.updatePetViaAPIDTO(createPetsRequestDTO2);

        CreatePetsResponseDTO createPetsResponseDTO = (CreatePetsResponseDTO) JsonUtils.convertJsonToDTO(
                response.getResponseBody(), CreatePetsResponseDTO.class.getCanonicalName());

        Assert.assertEquals(response.getStatusCode() , 200 , "Incorrect status code is shown");
        Assert.assertEquals(createPetsResponseDTO.getId() , petId ,"Incorrect Pet Id is shown" );
        Assert.assertEquals(createPetsResponseDTO.getName() , petName , "Incorrect Pet Name is shown");
        Assert.assertEquals(createPetsResponseDTO.getStatus() , updateStatus , "Incorrect Pet Status is shown");
        Assert.assertEquals(createPetsResponseDTO.getTags().get(0).getId() , tagID1 ,
                "Incorrect Tag Id is shown");
        Assert.assertEquals(createPetsResponseDTO.getTags().get(0).getName() , tagName1 ,
                "Incorrect Tag Name is shown");
        Assert.assertEquals(createPetsResponseDTO.getTags().get(1).getId() , tagID2 ,
                "Incorrect Tag Id is shown");
        Assert.assertEquals(createPetsResponseDTO.getTags().get(1).getName() , tagName2 ,
                "Incorrect Tag Name is shown");
        Assert.assertEquals(createPetsResponseDTO.getCategory().getId() , categoryId ,
                "Incorrect Category Id is shown");
        Assert.assertEquals(createPetsResponseDTO.getCategory().getName() , categoryName ,
                "Incorrect Category Name is shown");
        Assert.assertEquals(createPetsResponseDTO.getPhotoUrls().get(0) , photoUrl1 ,
                "Incorrect Photo Url is shown");
        Assert.assertEquals(createPetsResponseDTO.getPhotoUrls().get(1) , photoUrl2 ,
                "Incorrect Photo Url is shown");

    }
}
