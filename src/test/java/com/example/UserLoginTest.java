package com.example;

import com.example.data.LoginUserData;
import com.example.methods.ApiMethods;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserLoginTest {

    ApiMethods apiMethods;
    LoginUserData loginUserData;

    @Test
    @DisplayName("User login")
    public void loginUser() {

    apiMethods = new ApiMethods();

    loginUserData = LoginUserData.getRandom();

    ValidatableResponse login = apiMethods.loginUser(loginUserData);

    int statusCode = login.extract().statusCode();
    String token = login.extract().jsonPath().getString("token");

    assertThat("Status code is incorrect", statusCode, equalTo(200));
    assertThat("Token is not getting", token, is(notNullValue()));

    }

}
