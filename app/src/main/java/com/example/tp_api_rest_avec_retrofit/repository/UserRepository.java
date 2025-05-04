package com.example.tp_api_rest_avec_retrofit.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.tp_api_rest_avec_retrofit.model.User;
import com.example.tp_api_rest_avec_retrofit.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import androidx.lifecycle.MutableLiveData;

import com.example.tp_api_rest_avec_retrofit.model.User;
import com.example.tp_api_rest_avec_retrofit.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    public void fetchUsers(final MutableLiveData<List<User>> userListLiveData) {
        RetrofitClient.getApiService().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    userListLiveData.postValue(response.body());
                } else {
                    userListLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                userListLiveData.postValue(null);
            }
        });
    }
}

