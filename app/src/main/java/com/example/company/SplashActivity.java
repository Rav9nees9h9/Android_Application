package com.example.company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Runnable task = () ->{
            Intent intent = new Intent(this, MainActivity.class );
            startActivity(intent);
        };
        ScheduledExecutorService schrduleExecutorService = Executors.newSingleThreadScheduledExecutor();

        schrduleExecutorService.schedule(task, 2, TimeUnit.SECONDS);

    }
}