package com.bibek.twitter.api;

import com.bibek.twitter.model.Users;
import com.bibek.twitter.response.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UsersAPI {
    @POST("registerUser")
    Call<SignUpResponse> registerUser(@Body Users users);

    @FormUrlEncoded
    @POST("/login")
    Call<SignUpResponse> checkUser(@Field("email") String email, @Field("password") String password);
}
