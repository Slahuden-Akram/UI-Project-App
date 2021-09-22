package com.example.uiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details_Activity extends AppCompatActivity {

    TextView txtDesc,txtId,txtName;
    ImageView detailed_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailed_image = (ImageView) findViewById(R.id.detailed_image);
        txtName = (TextView) findViewById(R.id.txtName);
        txtId = (TextView) findViewById(R.id.txtId);
        txtDesc = (TextView) findViewById(R.id.txtDesc);

        detailed_image.setImageResource(getIntent().getIntExtra("Image",0));
        txtName.setText(getIntent().getStringExtra("Name"));
        txtId.setText(getIntent().getStringExtra("Id"));
        txtDesc.setText(getIntent().getStringExtra("Desc"));


    }
}