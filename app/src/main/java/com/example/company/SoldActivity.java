package com.example.company;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.*;
import android.os.Bundle;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SoldActivity extends BaseActivityVeh {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        int index = Integer.parseInt((intent.getStringExtra("index")));

        List<VehicleModel> soldVehicles = new ArrayList<>();

        ImageView vehPhoto = findViewById(R.id.veh_info);
        TextView make = findViewById(R.id.make_info);
        TextView model = findViewById(R.id.model_info);
        TextView condition = findViewById(R.id.condition_info);
        TextView engineCylinder = findViewById(R.id.engine_info);
        TextView year = findViewById(R.id.year_info);
        TextView numberOfDoors = findViewById(R.id.doors_info);
        TextView price = findViewById(R.id.price_info);
        TextView color = findViewById(R.id.color_info);
        TextView soldDate = findViewById(R.id.date_info);


        try{
            readFileContents();
        }
        catch (Exception e){
            Toast.makeText(this, "Could not read file contents", Toast.LENGTH_SHORT).show();
        }



        make.setText(soldVehicles.toString());
        model.setText(soldVehicles.toString());
        condition.setText(soldVehicles.toString());
        engineCylinder.setText(soldVehicles.toString());
        year.setText(soldVehicles.toString());
        numberOfDoors.setText(soldVehicles.toString());
        price.setText(soldVehicles.toString());
        color.setText(soldVehicles.toString());

        soldDate.setText(soldVehicles.toString());

        File file = new File(soldVehicles.get(vehPhoto));
        if(file.exists())
        {
            vehPhoto.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
        else {
            vehPhoto.setImageResource(R.drawable.sold);
        }
    }
}