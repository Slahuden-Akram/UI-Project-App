package com.example.uiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GIFY_ACTIVITY extends AppCompatActivity {
    ArrayList<DataModel> dataModels = new ArrayList<>();
    private myAdapter myAdapter;
    private RecyclerView rclView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gify);

        rclView = (RecyclerView) findViewById(R.id.rclView);
        rclView.setLayoutManager(new GridLayoutManager(this,3));
        getResponse();

    }

    private void getResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://navneet7k.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApi myApi = retrofit.create(MyApi.class);
        Call<List<DataModel>> call = myApi.getDataResponse();

        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                dataModels = new ArrayList<>(response.body());
                myAdapter = new myAdapter(dataModels, GIFY_ACTIVITY.this);
                rclView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

            }
        });
    }
}