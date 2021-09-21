package com.example.uiproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("cars_list.json")
    Call<List<DataModel>> getDataResponse();
}
