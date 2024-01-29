package com.example.data;

public class LoginUserData {

    private String email;
    private String password;
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LoginUserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static LoginUserData getData() {
        final String email = "eve.holt@reqres.in";
        final String password = "cityslicka";
        return new LoginUserData(email, password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
