package com.example.company;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends BaseActivityVeh {

    DetailActivity myAdapterVeh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view);

        vehicle.add(new VehicleModel("Audi","A4","Great","V4","2015","4","120500","Black","R.drawable.audi1","R.drawable.audi1",7,true));
        vehicle.add(new VehicleModel("BMW","M8","Great","V6","2018","4","121500","Red","R.drawable.bmw1","R.drawable.bmw1",4,true));
        vehicle.add(new VehicleModel("Audi","R8","Great","V8","2012","2","120500","Black","R.drawable.audi2","R.drawable.audi2",5,false));
        vehicle.add(new VehicleModel("Honda","Civic","Great","V4","2018","4","121500","Red","R.drawable.honda1","R.drawable.honda1",4,true));
        vehicle.add(new VehicleModel("Honda","Accord","Great","V5","2016","4","120500","Silver","R.drawable.honda2","R.drawable.honda2",10,false));
        vehicle.add(new VehicleModel("BMW","M4","Great","V10","2020","4","121500","Black","R.drawable.bmw2","R.drawable.bmw2",4,false));
        vehicle.add(new VehicleModel("Audi","R8","Great","V8","2012","2","120500","Black","R.drawable.audi2","R.drawable.audi2",5,false));
        vehicle.add(new VehicleModel("Honda","Civic","Great","V4","2018","4","121500","Red","R.drawable.honda1","R.drawable.honda1",4,true));
        vehicle.add(new VehicleModel("Honda","Accord","Great","V5","2016","4","120500","Silver","R.drawable.honda2","R.drawable.honda2",10,false));
        vehicle.add(new VehicleModel("BMW","M4","Great","V10","2020","4","121500","Black","R.drawable.bmw2","R.drawable.bmw2",4,false));


        vehicleList = findViewById(R.id.vehicle_details);



        AlertDialog.Builder confirmClearContentsDialog = new AlertDialog.Builder(this);
        confirmClearContentsDialog.setTitle("Are you sure?");

        confirmClearContentsDialog.setMessage("Clear all contents? This will erase all data");
        confirmClearContentsDialog.setCancelable(false);

        confirmClearContentsDialog.setPositiveButton("Yes", (arg0, arg1) -> {
            try {
                clearContents();
                readFileContents();
                myAdapterVeh.notifyDataSetChanged();
                readFileContents();
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

        confirmClearContentsDialog.setNegativeButton("No", (dialog, which) -> Toast.makeText(com.example.company.ViewActivity.this,"Good decision. (No clicked)",Toast.LENGTH_SHORT).show());
        confirmClearContentsDialog.setNeutralButton("Cancel", (dialog, which) -> Toast.makeText(getApplicationContext(),"Close call (Cancel clicked)",Toast.LENGTH_SHORT).show());

        AlertDialog alertDialog = confirmClearContentsDialog.create();

        View.OnClickListener onClickListener = view -> alertDialog.show();

        findViewById(R.id.clear_button).setOnClickListener(onClickListener);
        try{

            readFileContents();

        }
        catch (Exception e){
            Toast.makeText(com.example.company.ViewActivity.this,"Error to read file content",Toast.LENGTH_SHORT).show();
        }


        Button button = findViewById(R.id.reload_button);
        button.setOnClickListener(view -> {

            try{
                vehicle.clear();
                readFileContents();
                myAdapterVeh.notifyDataSetChanged();
            }
            catch (Exception e){
                Toast.makeText(com.example.company.ViewActivity.this, "Unable to complete function", Toast.LENGTH_SHORT).show();
            }

        });
        if(vehicle.size() == 0)
        {
            Toast.makeText(com.example.company.ViewActivity.this, "No vehicle entries found", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(com.example.company.ViewActivity.this, "Welcome to vehicle", Toast.LENGTH_SHORT).show();

        }


        vehicleList = findViewById(R.id.vehicle_details);
        myAdapterVeh = new DetailActivity(getApplicationContext(), vehicle);
        vehicleList.setAdapter(myAdapterVeh);

    }

    public void onCreateClick(View view) {

        startActivity(new Intent(getApplicationContext(), ModifyActivity.class));
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        VehicleModel vehicles = vehicle.get(position);
        String status = vehicles.isSold() ? "Sold" : "Available";
        Toast.makeText(com.example.company.ViewActivity.this,"Error occured",Toast.LENGTH_SHORT).show();

    }
    public void showAvailableVehicles(View view)
    {
        List<VehicleModel> availableVehicles = new ArrayList<>();
        for(VehicleModel vehicles : vehicle)
        {
            if(!vehicles.isSold())
            {
                availableVehicles.add(vehicles);
            }
        }
        startActivity(new Intent(getApplicationContext(), AvailableActivity.class));
    }
    public void showSoldVehicle(View view)
    {
        List<VehicleModel> soldVehicles = new ArrayList<>();
        for(VehicleModel vehicles : vehicle)
        {
            if(vehicles.isSold())
            {
                soldVehicles.add(vehicles);
            }
        }
        startActivity(new Intent(getApplicationContext(), SoldActivity.class));
    }

}



