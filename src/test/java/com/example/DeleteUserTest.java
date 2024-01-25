package com.example;

import com.example.data.CreatingUserData;
import com.example.methods.ApiMethods;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteUserTest {

    ApiMethods apiMethods;
    CreatingUserData creatingUserData;

    @Test
    @DisplayName("User deletion")
    public void deleteUser() {

        apiMethods = new ApiMethods();
        creatingUserData = CreatingUserData.getRandom();

        ValidatableResponse createUser = apiMethods.createUser(creatingUserData);

        int userId = createUser.extract().jsonPath().getInt("id");

        ValidatableResponse deleteUser = apiMethods.deleteUser(userId);

        int statusCode = deleteUser.extract().statusCode();

        assertThat("Status code is incorrect", statusCode, equalTo(204));

    }
}
