package com.assignment.api.common;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.lang.reflect.Method;

public class ApiBaseTest {


    @AfterMethod
    protected void testAPIMethodEnd(Method method, ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
            } else if (result.getStatus() == ITestResult.FAILURE) {
            }
        } catch (Exception e) {
            System.out.println("Log Message:: Exception caught");
            e.printStackTrace();
        }
    }

}
