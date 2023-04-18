package com.example.company;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class CompanyActivity extends BaseActivity {

    CompanyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_company);

        AlertDialog.Builder confirmClearContentsDialog = new AlertDialog.Builder(this);
        confirmClearContentsDialog.setTitle("Are you sure?");

        confirmClearContentsDialog.setMessage("Clear all contents? This will erase all data");
        confirmClearContentsDialog.setCancelable(false);

        confirmClearContentsDialog.setPositiveButton("Yes", (arg0, arg1) -> {
            try {
                clearContents();
                readFileContents();
                myAdapter.notifyDataSetChanged();
                readFileContents();
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

        confirmClearContentsDialog.setNegativeButton("No", (dialog, which) -> Toast.makeText(com.example.company.CompanyActivity.this,"Good decision. (No clicked)",Toast.LENGTH_SHORT).show());
        confirmClearContentsDialog.setNeutralButton("Cancel", (dialog, which) -> Toast.makeText(getApplicationContext(),"Close call (Cancel clicked)",Toast.LENGTH_SHORT).show());

        AlertDialog alertDialog = confirmClearContentsDialog.create();

        View.OnClickListener onClickListener = view -> alertDialog.show();

        findViewById(R.id.clear_contents).setOnClickListener(onClickListener);
        try{

            readFileContents();

        }
        catch (Exception e){
            Toast.makeText(com.example.company.CompanyActivity.this,"Error to read file content",Toast.LENGTH_SHORT).show();
        }


        Button button = findViewById(R.id.reload_contents);
        button.setOnClickListener(view -> {

            try{
                company.clear();
                readFileContents();
                myAdapter.notifyDataSetChanged();
            }
            catch (Exception e){
                Toast.makeText(com.example.company.CompanyActivity.this, "Unable to complete function", Toast.LENGTH_SHORT).show();
            }

        });


        companyList = findViewById(R.id.company_details);
        myAdapter = new CompanyAdapter(getApplicationContext(), company);
        companyList.setAdapter(myAdapter);

        }

    public void onCreateClick(View view) {

        startActivity(new Intent(getApplicationContext(), ModifyDetailsActivity.class));
    }
}



