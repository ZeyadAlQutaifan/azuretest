package com.example.demo.users.models;

public class LoginResult {
    public int resultCode;
    public String resultMessage;
    public Integer userType;

    public LoginResult(int resultCode, String resultMessage, Integer userType) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.userType = userType;
    }

}
