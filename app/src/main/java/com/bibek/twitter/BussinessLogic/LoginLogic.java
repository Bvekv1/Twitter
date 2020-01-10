package com.bibek.twitter.BussinessLogic;

import com.bibek.twitter.api.UsersAPI;
import com.bibek.twitter.response.SignUpResponse;
import com.bibek.twitter.strictmode.StrictModeClass;
import com.bibek.twitter.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginLogic {
    private Boolean isSuccess = false;

    public boolean checkUser(String email, String password) {
        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> userCall = usersAPI.checkUser(email, password);
        StrictModeClass.StrictMode();
        try {
            Response<SignUpResponse> loginResponse = userCall.execute();
            if (loginResponse.isSuccessful()) {
                loginResponse.body().getStatus().equals("Login Success");
                URL.token += loginResponse.body().getToken();

                isSuccess = true;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return isSuccess;

    }
}