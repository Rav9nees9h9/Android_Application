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

public class CompanyAdapter extends ArrayAdapter<CompanyModel>
{
    public CompanyAdapter(Context applicationContext, ArrayList<CompanyModel> company)
    {
        super(applicationContext, R.layout.activity_info,company);

    }
    public View getView(int i, View view, ViewGroup parent)
    {
        CompanyModel company = getItem(i);

        if(view == null)
        {
            view  = LinearLayout.inflate(getContext(), R.layout.activity_info,null);

        }
        ImageView photo = view.findViewById(R.id.image_info);
        EditText name = view.findViewById(R.id.name_info);
        EditText address = view.findViewById(R.id.address_info);

        name.setText(company.getCompanyName());
        address.setText(company.getAddress());

        File file = new File(company.getImage());

        if(file.exists())
        {
            photo.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
        else{
            photo.setImageResource(R.drawable.sold);
        }
        return view;
    }
}
