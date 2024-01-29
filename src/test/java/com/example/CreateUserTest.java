package com.example;

import com.example.data.CreatingUserData;
import com.example.methods.ApiMethods;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUserTest {

    ApiMethods apiMethods;
    CreatingUserData creatingUserData;
    int userId;

    @Before
    public void setUp()  {
        apiMethods = new ApiMethods();
    }

    @Test
    @DisplayName("Creating of user")
    public void createUser() {

        creatingUserData = CreatingUserData.getData();

        ValidatableResponse createUser = apiMethods.createUser(creatingUserData);

        int statusCode = createUser.extract().statusCode();
        String userId = createUser.extract().jsonPath().get("id");
        String name = createUser.extract().jsonPath().get("name");
        String job = createUser.extract().jsonPath().get("job");

        assertThat("Status code is incorrect", statusCode, equalTo(201));
        assertThat("User ID is incorrect", userId, is(notNullValue()));
        assertThat("Name is incorrect", name, is(creatingUserData.getName()));
        assertThat("Job is incorrect", job, is(creatingUserData.getJob()));

    }

    @After
    public void deleteUser() {

        apiMethods = new ApiMethods();

        ValidatableResponse createUser = apiMethods.createUser(creatingUserData);

        int userId = createUser.extract().jsonPath().getInt("id");

        ValidatableResponse deleteUser = apiMethods.deleteUser(userId);

        int statusCode = deleteUser.extract().statusCode();

        assertThat("Status code is incorrect", statusCode, equalTo(204));

    }

}
