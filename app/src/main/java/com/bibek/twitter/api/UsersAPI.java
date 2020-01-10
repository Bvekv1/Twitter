package com.bibek.twitter.api;

import com.bibek.twitter.model.Users;
import com.bibek.twitter.response.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsersAPI {
    @POST("registerUser")
    Call<SignUpResponse> registerUser(@Body Users users);
}
