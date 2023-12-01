package tpolab11.service;

import tpolab11.model.User;

public class UserFactory {
    public static User getUserInfo() {
        return new User(TestDataReader.getTestData("email"),
                        TestDataReader.getTestData("password"));
    }
}
