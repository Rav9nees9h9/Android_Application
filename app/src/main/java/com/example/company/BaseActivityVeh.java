package com.example.company;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class BaseActivityVeh extends AppCompatActivity {

        ListView vehicleList;
        ArrayList<VehicleModel> vehicle = new ArrayList<>();


        final String dbVeh_file = "myfilecontent";

        final String FILE_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";

        public static final int to_locate = 100;
        public static final int retrieve_images = 900;
        Random random = new Random();


        public String randomStringGenerator(int limit) {
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'

            return random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(limit)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }

        protected void readFileContents() throws Exception {

            FileInputStream fileInputStream = openFileInput(dbVeh_file);

            Scanner scanner = new Scanner(fileInputStream);


            while (scanner.hasNext()) {
                String content = scanner.nextLine();
                VehicleModel vehicleDetails = new VehicleModel();
                String[] data = content.split(",");
                vehicleDetails.setMake(data[0]);
                vehicleDetails.setModel(data[1]);
                vehicleDetails.setCondition(data[2]);
                vehicleDetails.setEngineCylinder(data[3]);
                vehicleDetails.setYear(data[4]);
                vehicleDetails.setNumberOfDoors(data[5]);
                vehicleDetails.setPrice(data[6]);
                vehicleDetails.setColor(data[7]);
                vehicleDetails.setThumbnailImage(data[8]);
                vehicleDetails.setFullImage(data[9]);
                boolean isSold = Boolean.parseBoolean(data[10]);
                vehicle.add(vehicleDetails);


            }

        }

        protected void writeFileContents(String content) throws Exception
        {

            FileOutputStream fileOutputStream = openFileOutput(dbVeh_file, Context.MODE_APPEND);

            fileOutputStream.write(content.getBytes());

        }

        protected void clearContents() throws Exception
        {

            FileOutputStream fileOutputStream = openFileOutput(dbVeh_file, Context.MODE_PRIVATE);

            fileOutputStream.write("".getBytes());

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_main, menu);

            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()) {
                case R.id.menu:
                    //create an Intent
                    Intent intent = new Intent(this, ViewActivity.class);
                    //start new activity
                    startActivity(intent);
                    break;

            }

            return true;

        }

        public void disableEditText(EditText editText) {
            editText.setFocusable(false);
            editText.setEnabled(false);
            editText.setCursorVisible(false);
            editText.setKeyListener(null);
            editText.setBackgroundColor(Color.TRANSPARENT);
        }


    }


