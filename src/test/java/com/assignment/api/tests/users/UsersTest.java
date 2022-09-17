package com.assignment.api.tests.users;

import com.assignment.api.common.ApiBaseTest;
import com.assignment.api.flows.users.UsersFlow;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class UsersTest extends ApiBaseTest {


    UsersFlow usersFlow = new UsersFlow();


    @Test(description = "create and verifying users")
    @Description("Create multiple users by create users api")
    public void addAndVerifyMultipleUsersTest(){
        usersFlow.addAndVerifyMultipleUsers();
    }

    @Test(description = "update and verify users")
    @Description("Update user by username by update api")
    public void updateAndVerifyUserTest(){
        usersFlow.updateAndVerifyUser();
    }

    @Test(description = "get valid user details")
    @Description("verifying valid user details by username by get user api")
    public void verifyUserDetailsByValidUsernameTest(){
        usersFlow.verifyUserDetailsByValidUsername();
    }

    @Test(description = "get invalid user details")
    @Description("verifying invalid user details by username by get user api")
    public void verifyUserDetailsByInvalidUsernameTest(){
        usersFlow.verifyUserDetailsByInvalidUsername();
    }
}
