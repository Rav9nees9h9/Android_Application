package com.example.company;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class AddActivity extends BaseActivityVeh {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


    Button addButton = findViewById(R.id.add_id);
    addButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        EditText make = findViewById(R.id.make_id);
        EditText model = findViewById(R.id.model_id);
        EditText condition = findViewById(R.id.condition_id);
        EditText engineCylinder = findViewById(R.id.engine_id);
        EditText year = findViewById(R.id.year_id);
        EditText numberOfRooms = findViewById(R.id.doors_id);
        EditText price = findViewById(R.id.price_id);
        EditText color = findViewById(R.id.color_id);
        ImageView image = findViewById(R.id.image_id);
        ImageView thumnailImage = findViewById(R.id.thumbnail_id);


        String makeVeh = make.getText().toString();
        String modelVeh = model.getText().toString();
        String conditionVeh = condition.getText().toString();
        String engineCyl = engineCylinder.getText().toString();
        String yearVeh = year.getText().toString();
        String doorsVeh = numberOfRooms.getText().toString();
        String priceVeh = price.getText().toString();
        String colorVeh = color.getText().toString();


        if (makeVeh.isEmpty()) {
            make.setError("Maker is required");
            return;
        }

        if (modelVeh.isEmpty()) {
            model.setError("Model is required");
            return;
        }

        if (conditionVeh.isEmpty()) {
            condition.setError("Price is required");
            return;
        }
        if (engineCyl.isEmpty()) {
            engineCylinder.setError("Price is required");
            return;
        }
        if (yearVeh.isEmpty()) {
            year.setError("Price is required");
            return;
        }
        if (doorsVeh.isEmpty()) {
            numberOfRooms.setError("Price is required");
            return;
        }
        if (priceVeh.isEmpty()) {
            price.setError("Price is required");
            return;
        }
        if (colorVeh.isEmpty()) {
            color.setError("Price is required");
            return;
        }
    }
    });



    }
}