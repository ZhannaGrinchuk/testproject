package com.example;

import com.example.methods.ApiMethods;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListOfUsersTest {
    ApiMethods apiMethods;

    @Test
    @DisplayName("Getting list of users")
    public void checkListOfUsers() {

        apiMethods = new ApiMethods();
        ValidatableResponse getUsers = apiMethods.getListOfUsers();

        int statusCode = getUsers.extract().statusCode();

        assertThat("Status code is incorrect", statusCode, equalTo(200));

    }

}
