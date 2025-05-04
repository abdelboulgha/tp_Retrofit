package com.example.tp_api_rest_avec_retrofit.network;

import com.example.tp_api_rest_avec_retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("users")
    Call<List<User>> getUsers();
}
