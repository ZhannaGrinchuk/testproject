package com.example;

import com.example.methods.ApiMethods;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetUserTest {

    ApiMethods apiMethods;

    @Test
    @DisplayName("Getting of user")
    public void checkUserTest() {

        apiMethods = new ApiMethods();
        ValidatableResponse getUser = apiMethods.getUser();

        int statusCode = getUser.extract().statusCode();

        assertThat("Status code is incorrect", statusCode, equalTo(200));

    }

}
