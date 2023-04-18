package com.example.company;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.util.ArrayList;

public class DetailActivity extends ArrayAdapter<VehicleModel>
{
    public DetailActivity(Context applicationContext, ArrayList<VehicleModel> vehicle)
    {
        super(applicationContext, R.layout.activity_details,vehicle);

    }
    public View getView(int i, View view, ViewGroup parent)
    {
        VehicleModel vehicle = getItem(i);

        if(view == null)
        {
            view  = LinearLayout.inflate(getContext(), R.layout.activity_details,null);

        }
        ImageView vehPhoto = view.findViewById(R.id.veh_info);
        EditText make = view.findViewById(R.id.make_info);
        EditText model = view.findViewById(R.id.model_info);
        EditText condition = view.findViewById(R.id.condition_info);
        EditText engineCylinder = view.findViewById(R.id.engine_info);
        EditText year = view.findViewById(R.id.year_info);
        EditText numberOfDoors = view.findViewById(R.id.doors_info);
        EditText price = view.findViewById(R.id.price_info);
        EditText color = view.findViewById(R.id.color_info);
        EditText aoldDate = view.findViewById(R.id.date_info);

        make.setText(vehicle.getMake());
        model.setText(vehicle.getModel());
        condition.setText(vehicle.getCondition());
        engineCylinder.setText(vehicle.getEngineCylinder());
        year.setText(vehicle.getYear());
        numberOfDoors.setText(vehicle.getNumberOfDoors());
        price.setText(vehicle.getPrice());
        color.setText(vehicle.getColor());
        aoldDate.setText(vehicle.getSoldDate());


        File file = new File(vehicle.getFullImage());

        if(file.exists())
        {
            vehPhoto.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
        else{
            vehPhoto.setImageResource(R.drawable.audi1);
        }
        return view;
    }
}
