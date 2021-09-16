package com.example.uiproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyFilesActivity extends AppCompatActivity {
    RecyclerView rcl;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_files);

        img = (ImageView) findViewById(R.id.imgNext);
        rcl = (RecyclerView) findViewById(R.id.rclView);
        rcl.setLayoutManager(new GridLayoutManager(this, 3));


        String arr[]={"C","C++","Java","PHP","Python","JavaScript","C","C++","Java","PHP","Python","JavaScript","C","C++","Java","PHP","Python","JavaScript","C","C++","Java","PHP","Python","JavaScript"};
        rcl.setAdapter(new myAdapter(arr));
        MyFilesActivity m = new MyFilesActivity();
        m.finish();

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFilesActivity.this,GIFY_ACTIVITY.class);
                startActivity(intent);
            }
        });

    }

}
