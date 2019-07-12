package com.bucur.grasp.expert;

public class Controller {

    AuthenticationModule authenticationModule;

    public Controller(AuthenticationModule authenticationModule) {
        this.authenticationModule = authenticationModule;
    }

    public void authenticateUser(LoginRequest loginRequest) {
        authenticationModule.authenticate(loginRequest);
    }


}
