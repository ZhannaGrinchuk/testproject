package com.example.methods;

import com.example.data.CreatingUserData;
import com.example.data.LoginUserData;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ApiMethods extends RestAssuredClient {
    @Step("Getting list of users")
    public ValidatableResponse getListOfUsers() {
        return given()
                .spec(getBaseSpec())
                .when()
                .log().uri()
                .get("users")
                .then()
                .log().body();
    }

    @Step("Getting of user")
    public ValidatableResponse getUser() {
        return given()
                .spec(getBaseSpec())
                .when()
                .log().uri()
                .get("users/2")
                .then()
                .log().body();
    }

    @Step("Create user")
    public ValidatableResponse createUser(CreatingUserData creatingUserData) {
        return given()
                .spec(getBaseSpec())
                .body(creatingUserData)
                .when()
                .log().uri()
                .log().body()
                .post("users/")
                .then()
                .log().body();
    }

    @Step("Delete user")
    public ValidatableResponse deleteUser(int userId) {
        return given()
                .spec(getBaseSpec())
                .when()
                .log().uri()
                .delete("users/" + userId)
                .then()
                .log().body();
    }


    @Step("Successful login")
    public ValidatableResponse loginUser(LoginUserData loginUserData) {
        return given()
                .spec(getBaseSpec())
                .body(loginUserData)
                .when()
                .log().uri()
                .post("login")
                .then()
                .log().body();
    }

}



