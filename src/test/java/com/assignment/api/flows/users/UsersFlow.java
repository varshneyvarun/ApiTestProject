package com.assignment.api.flows.users;

import com.assignment.api.core.APIResponse;
import com.assignment.api.module.users.actions.UsersActions;
import com.assignment.api.module.users.request.CreateUsersRequestDTO;
import com.assignment.api.module.users.response.CreateUsersResponseDTO;
import com.assignment.api.module.users.response.GetUserResponseDTO;
import com.assignment.utils.JsonUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.lib.support.TestData.*;


public class UsersFlow {



    public void addAndVerifyMultipleUsers(){
        CreateUsersRequestDTO createUsersDTO1 = new CreateUsersRequestDTO();

        int id1 = getIdValue();
        int id2 = getIdValue();

        String username1 = getAutoUserName();
        String username2 = getAutoUserName();

        String firstName1 = getAutoFirstName();
        String firstName2 = getAutoFirstName();

        String lastName1 = getAutoLastName();
        String lastName2 = getAutoLastName();

        String email1 = "abc@xyz.com";
        String email2 = "pqr@xyz.com";

        String password1 = getAutoPassword();
        String password2 = getAutoPassword();

        String phone1 = geAutoPhoneNumber();
        String phone2 = geAutoPhoneNumber();

        int userStatus1 = 0;
        int userStatus2 = 1;

        createUsersDTO1.setId(id1).setUsername(username1)
                .setFirstName(firstName1)
                .setLastName(lastName1)
                .setEmail(email1)
                .setPassword(password1)
                .setPhone(phone1)
                .setUserStatus(userStatus1);

        CreateUsersRequestDTO createUsersDTO2 = new CreateUsersRequestDTO();


        createUsersDTO2.setId(id2)
                .setUsername(username2)
                .setFirstName(firstName2)
                .setLastName(lastName2)
                .setEmail(email2)
                .setPassword(password2)
                .setPhone(phone2)
                .setUserStatus(userStatus2);

        List<CreateUsersRequestDTO> list = new ArrayList<>();

        list.add(createUsersDTO1);
        list.add(createUsersDTO2);


        UsersActions usersActions = new UsersActions();

        APIResponse response = usersActions.addUsersViaAPIDTO(list);

        CreateUsersResponseDTO createUsersResponse = (CreateUsersResponseDTO) JsonUtils.convertJsonToDTO(
                response.getResponseBody(), CreateUsersResponseDTO.class.getCanonicalName());

        Assert.assertEquals(response.getStatusCode() , 200 , "Incorrect status code is shown");
        Assert.assertEquals(createUsersResponse.getCode() , 200 , "Incorrect code is shown");
        Assert.assertEquals(createUsersResponse.getType() , "unknown" , "Incorrect type is shown");
        Assert.assertEquals(createUsersResponse.getMessage() , "ok" , "Incorrect type is shown");

    }

    public void updateAndVerifyUser(){
        CreateUsersRequestDTO createUsersDTO1 = new CreateUsersRequestDTO();

        int id1 = getIdValue();
        int id2 = getIdValue();

        String username1 = getAutoUserName();
        String username2 = getAutoUserName();

        String firstName1 = getAutoFirstName();
        String firstName2 = getAutoFirstName();

        String lastName1 = getAutoLastName();
        String lastName2 = getAutoLastName();

        String email1 = "abc@xyz.com";
        String email2 = "pqr@xyz.com";

        String password1 = getAutoPassword();
        String password2 = getAutoPassword();

        String phone1 = geAutoPhoneNumber();
        String phone2 = geAutoPhoneNumber();

        int userStatus1 = 0;
        int userStatus2 = 1;

        createUsersDTO1.setId(id1).setUsername(username1)
                .setFirstName(firstName1)
                .setLastName(lastName1)
                .setEmail(email1)
                .setPassword(password1)
                .setPhone(phone1)
                .setUserStatus(userStatus1);

        List<CreateUsersRequestDTO> list = new ArrayList<>();

        list.add(createUsersDTO1);

        UsersActions usersActions = new UsersActions();

        usersActions.addUsersViaAPIDTO(list);


        CreateUsersRequestDTO createUsersDTO2 = new CreateUsersRequestDTO();

        createUsersDTO2.setId(id2)
                .setUsername(username2)
                .setFirstName(firstName2)
                .setLastName(lastName2)
                .setEmail(email2)
                .setPassword(password2)
                .setPhone(phone2)
                .setUserStatus(userStatus2);



        APIResponse response = usersActions.updateUsersViaAPIDTO(createUsersDTO2 , username1);

        CreateUsersResponseDTO createUsersResponse = (CreateUsersResponseDTO) JsonUtils.convertJsonToDTO(
                response.getResponseBody(), CreateUsersResponseDTO.class.getCanonicalName());


        Assert.assertEquals(response.getStatusCode() , 200 , "Incorrect status code is shown");
        Assert.assertEquals(createUsersResponse.getCode() , 200 , "Incorrect code is shown");
        Assert.assertEquals(createUsersResponse.getType() , "unknown" , "Incorrect type is shown");
        Assert.assertEquals(createUsersResponse.getMessage(), String.valueOf(id2) , "Incorrect message is shown");

    }
    public void verifyUserDetailsByValidUsername(){

        CreateUsersRequestDTO createUsersDTO1 = new CreateUsersRequestDTO();

        int id1 = getIdValue();
        String username1 = getAutoUserName();
        String firstName1 = getAutoFirstName();
        String lastName1 = getAutoLastName();
        String email1 = "abc@xyz.com";
        String password1 = getAutoPassword();
        String phone1 = geAutoPhoneNumber();
        int userStatus1 = 0;


        createUsersDTO1.setId(id1).setUsername(username1)
                .setFirstName(firstName1)
                .setLastName(lastName1)
                .setEmail(email1)
                .setPassword(password1)
                .setPhone(phone1)
                .setUserStatus(userStatus1);

        List<CreateUsersRequestDTO> list = new ArrayList<>();

        list.add(createUsersDTO1);

        UsersActions usersActions = new UsersActions();

        usersActions.addUsersViaAPIDTO(list);


        APIResponse response = usersActions.getUserDetailsViaAPI(username1);

        GetUserResponseDTO getUserResponseDTO = (GetUserResponseDTO) JsonUtils.convertJsonToDTO(
                response.getResponseBody(), GetUserResponseDTO.class.getCanonicalName());

        Assert.assertEquals(response.getStatusCode() , 200 , "Incorrect status code is shown");
        Assert.assertEquals(getUserResponseDTO.getId() , id1 , "Incorrect id is shown");
        Assert.assertEquals(getUserResponseDTO.getUsername() , username1 , "Incorrect username is shown");
        Assert.assertEquals(getUserResponseDTO.getFirstName() , firstName1 , "Incorrect firstName is shown");
        Assert.assertEquals(getUserResponseDTO.getLastName() , lastName1 , "Incorrect lastName is shown");
        Assert.assertEquals(getUserResponseDTO.getEmail() , email1 , "Incorrect type is shown");
        Assert.assertEquals(getUserResponseDTO.getPassword() , password1 , "Incorrect type is shown");
        Assert.assertEquals(getUserResponseDTO.getPhone() , phone1 , "Incorrect type is shown");
        Assert.assertEquals(getUserResponseDTO.getUserStatus() , userStatus1 , "Incorrect type is shown");

    }

    public void verifyUserDetailsByInvalidUsername(){

        String username = getAutoUserName();


        UsersActions usersActions = new UsersActions();

        APIResponse response = usersActions.getUserDetailsViaAPI(username);

        CreateUsersResponseDTO createUsersResponse = (CreateUsersResponseDTO) JsonUtils.convertJsonToDTO(
                response.getResponseBody(), CreateUsersResponseDTO.class.getCanonicalName());

        Assert.assertEquals(response.getStatusCode() , 404 , "Incorrect status code is shown");
        Assert.assertEquals(createUsersResponse.getCode() , 1 , "Incorrect code is shown");
        Assert.assertEquals(createUsersResponse.getType() , "error" , "Incorrect type is shown");
        Assert.assertEquals(createUsersResponse.getMessage() , "User not found" ,
                "Incorrect message is shown");

    }




}
