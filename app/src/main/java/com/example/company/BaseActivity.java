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

public class BaseActivity extends AppCompatActivity {

        ListView companyList;
        ArrayList<CompanyModel> company = new ArrayList<>();
        final String db_file = "myfile";

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

            FileInputStream fileInputStream = openFileInput(db_file);

            Scanner scanner = new Scanner(fileInputStream);


            while (scanner.hasNext()) {
                String content = scanner.nextLine();
                CompanyModel companyDetails = new CompanyModel();
                String[] data = content.split(",");
                companyDetails.setCompanyName(data[1]);
                companyDetails.setAddress(data[2]);
                companyDetails.setImage(data[0]);
                company.add(companyDetails);


            }

        }

        protected void writeFileContents(String content) throws Exception
        {

            FileOutputStream fileOutputStream = openFileOutput(db_file, Context.MODE_APPEND);

            fileOutputStream.write(content.getBytes());

        }

        protected void clearContents() throws Exception
        {

            FileOutputStream fileOutputStream = openFileOutput(db_file, Context.MODE_PRIVATE);

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
                    Intent intent = new Intent(this, CompanyActivity.class);
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


