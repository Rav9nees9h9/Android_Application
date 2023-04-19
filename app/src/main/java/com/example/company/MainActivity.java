package com.example.company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends BaseActivity {
   // private static final int SPLASH_SCREEN_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button view = findViewById(R.id.button_view);
        Button details = findViewById(R.id.button_det);
        Button compDetails = findViewById(R.id.button_comp);
        Button modify = findViewById(R.id.button_modify);
        Button addVehicle = findViewById(R.id.button_add);
        Button mod = findViewById(R.id.button_mod);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                int selectedItemID = view.getId();

                Intent intent;

                switch (selectedItemID) {
                    case R.id.button_view:
                        intent = new Intent(getApplicationContext(), ViewActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button_det:
                        intent = new Intent(getApplicationContext(), DetailActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button_comp:
                        intent = new Intent(getApplicationContext(), CompanyActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button_modify:
                        intent = new Intent(getApplicationContext(), ModifyActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button_add:
                        intent = new Intent(getApplicationContext(), AddActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button_mod:
                        intent = new Intent(getApplicationContext(), ModifyDetailsActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Snackbar.make(view,"Unknown Value", Snackbar.LENGTH_LONG).show();
                }
            }
        };
        view.setOnClickListener(onClickListener);
        details.setOnClickListener(onClickListener);
        compDetails.setOnClickListener(onClickListener);
        modify.setOnClickListener(onClickListener);
        addVehicle.setOnClickListener(onClickListener);
        mod.setOnClickListener(onClickListener);


    }
}