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

public class ModifyDetailsActivity extends BaseActivity {
    ImageView image;
    CompanyModel company = new CompanyModel();
    private final String logo = "sold.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_details);


        image = findViewById(R.id.company_logo);
        company.setImage(logo);

        Button editButton = findViewById(R.id.edit_button);
        editButton.setVisibility(View.INVISIBLE);

        Button deleteButton = findViewById(R.id.delete_button);
        deleteButton.setVisibility(View.INVISIBLE);

        askForPermissions();

    }

    public void onChooseLogo(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent, "Please select image"), retrieve_images);

    }

    public void onSubmitClick(View view) {

        EditText name = findViewById(R.id.company_name);
        EditText address = findViewById(R.id.company_address);
        String companyName = name.getText().toString();
        String companyAddress = address.getText().toString();

        if(companyName.length() < 3 )
        {
            Toast.makeText(this, "Please enter a valid company name", Toast.LENGTH_SHORT).show();
        }
        if(companyAddress.length() < 3)
        {
            Toast.makeText(this, "Please enter a valid company address", Toast.LENGTH_SHORT).show();
        }

        try {
            company.setCompanyName(name.getText().toString());
            company.setAddress(address.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }
    }

    @Override
    protected void onActivityResult(int response, int result, Intent info) {

        super.onActivityResult(response, result, info);

        String filename = ".png";

        String file_path = filename;
        File file = new File(file_path);
        Bitmap photo;
        InputStream stream;
        company.setImage(file_path);

        if (response == to_locate) {

            photo = (Bitmap) info.getExtras().get("data");
            image.setImageBitmap(photo);

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
                image.setImageBitmap(photo);


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

