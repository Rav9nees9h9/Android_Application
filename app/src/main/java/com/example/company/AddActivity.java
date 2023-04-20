package com.example.company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
                Button image = findViewById(R.id.add_image);
                Button thumnailImage = findViewById(R.id.add_thumbnail);


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
                try {
                    writeFileContents(vehicle.writeToFile());
                    startActivity(new Intent(this, ViewActivity.class));
                } catch (Exception e) {
                    Toast.makeText(this, "Could not write to file", Toast.LENGTH_SHORT).show();
                }
            }

            public void addImage(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");

                startActivityForResult(Intent.createChooser(intent, "Please choose image"), retrieve_images);

            }


        });


    }

    @Override
    protected void onActivityResult(int response, int result, Intent info) {

        super.onActivityResult(response, result, info);

        String filename = randomStringGenerator(20) + ".png";

        String file_path = FILE_DIR + filename;
        File file = new File(file_path);
        Bitmap photo;
        InputStream stream;


        if (response == to_locate) {

            photo = (Bitmap) info.getExtras().get("data");


            try {
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                photo.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.close();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }


        if (response == retrieve_images) {

            Uri locationOfImage = info.getData();

            try {
                stream = getContentResolver().openInputStream(locationOfImage);
                photo = BitmapFactory.decodeStream(stream);


                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                photo.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.close();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

            }

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