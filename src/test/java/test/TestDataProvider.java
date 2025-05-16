package test;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][] {
                {"Admin", "admin123"}
        };
    }

    @DataProvider(name = "employeeData")
    public Object[][] provideEmployeeData() {
        return new Object[][] {
                {"John", "Doe"},
        };
    }

    @DataProvider(name = "searchData")
    public Object[][] searchEmployee() {
        return new Object[][] {
                {"Admin"}
        };
    }



}
