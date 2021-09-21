package com.example.uiproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyFilesActivity extends AppCompatActivity {

    ArrayList<DataModel> dataModels = new ArrayList<>();
    private myAdapter myAdapter;
    private RecyclerView rclView;
    ImageView img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_files);

        //Intent to GIPHY
        img = (ImageView) findViewById(R.id.imgNext);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFilesActivity.this,GIFY_ACTIVITY.class);
                startActivity(intent);
            }
        });

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
                myAdapter = new myAdapter(dataModels, MyFilesActivity.this);
                rclView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

            }
        });
    }

}