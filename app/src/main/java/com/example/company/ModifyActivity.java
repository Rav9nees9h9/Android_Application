package com.example.company;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ModifyActivity extends BaseActivityVeh {
    VehicleModel vehicle = new VehicleModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);


        Button editButton = findViewById(R.id.edit_vehbutton);
        editButton.setVisibility(View.INVISIBLE);

        Button deleteButton = findViewById(R.id.delete_vehbutton);
        deleteButton.setVisibility(View.INVISIBLE);

        askForPermissions();

    }

        public void onSubmitClick (View view){

        EditText price = findViewById(R.id.price_val);
        EditText date = findViewById(R.id.date_val);
        String priceVal = price.getText().toString();
        int soldDate = Integer.parseInt(date.getText().toString());

        if(soldDate < 0)
        {
            Toast.makeText(this, "Please enter a valid date", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            vehicle.setPrice(price.getText().toString());
            vehicle.setSoldDate(Integer.parseInt(date.getText().toString()));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }
    }


    public void askForPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivity(intent);

            }
            }
        }
    }


