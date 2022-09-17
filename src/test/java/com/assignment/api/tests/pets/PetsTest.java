package com.assignment.api.tests.pets;

import com.assignment.api.common.ApiBaseTest;
import com.assignment.api.flows.pets.PetsFlow;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PetsTest extends ApiBaseTest {

    PetsFlow petsFlow = new PetsFlow();

    @Test(description = "create and verifying pet")
    @Description("Create and verify pet by create pet api")
    public void addAndVerifyPetTest(){
        petsFlow.addAndVerifyPet();
    }

    @Test(description = "verify pet details" , dataProvider = "statusProvider")
    @Description("get pet details find by status")
    public void verifyPertDetailsByStatusTest(String status){
        petsFlow.verifyPertDetailsByStatus(status);
    }

    @DataProvider(name = "statusProvider")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]
                {{"available"}, {"pending"}, {"sold"}};
    }

    @Test(description = "update and verify pet details")
    @Description("update and verify pet details")
    public void updateAndVerifyPertDetailsTest(){
        petsFlow.updateAndVerifyPertDetails();
    }


}
