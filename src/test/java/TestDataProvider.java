public class TestDataProvider {
    public Object[][] provideEmployeeData() {
        return new Object[][] {
                {"John", "Doe"},
                {"Jane", "Smith"},
                {"Alice", "Johnson"}
        };
    }

    public Object[][] provideLoginData() {
        return new Object[][] {
                {"Admin", "admin123"}
        };
    }

}
