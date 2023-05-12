//This is like a service file

package com.example.login3;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

    @POST("register")
    Call<ResponseBody> createUser (
            @Body User user
    );

    @POST("login")
    Call<ResponseBody> checkUser (
            @Body User user
    );



}
