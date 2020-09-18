package com.example.fastlk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class AdsViewActivity extends AppCompatActivity {
    private ListView adListView;
    private Button catBtn, locBtn;
    private Spinner dialogSp, dialog2Sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_view);

        adListView = findViewById(R.id.ads_lv);
        catBtn = findViewById(R.id.cat_btn);
        locBtn = findViewById(R.id.loc_btn);
        ArrayList<Ad> ads = new ArrayList<>();

        ads.add(new Ad(R.drawable.ic_launcher_background, "Car", "1000000"));
        ads.add(new Ad(R.drawable.ic_launcher_background, "Car", "1000000"));
        ads.add(new Ad(R.drawable.ic_launcher_background, "Car", "1000000"));
        ads.add(new Ad(R.drawable.ic_launcher_background, "Car", "1000000"));
        ads.add(new Ad(R.drawable.ic_launcher_background, "Car", "1000000"));
        ads.add(new Ad(R.drawable.ic_launcher_background, "Car", "1000000"));
        ads.add(new Ad(R.drawable.ic_launcher_background, "Car", "1000000"));
        ads.add(new Ad(R.drawable.ic_launcher_background, "Car", "1000000"));
        ads.add(new Ad(R.drawable.ic_launcher_background, "Car", "1000000"));

        AdAdapter adAdapter = new AdAdapter(this, R.layout.ad_row, ads);
        adListView.setAdapter(adAdapter);

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdsViewActivity.this);
                builder.setTitle("Select Category");
                View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                dialogSp = view.findViewById(R.id.dialog_sp);
                dialog2Sp = view.findViewById(R.id.dialog2_sp);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AdsViewActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.categories));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dialogSp.setAdapter(adapter);


                dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    ArrayAdapter<String> adapter;
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0){
                            adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.vehicles));
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            dialog2Sp.setAdapter(adapter);
                        } else if (position ==1){
                            adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.properties));
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            dialog2Sp.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setView(view);
                builder.create().show();
            }
        });

        locBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdsViewActivity.this);
                builder.setTitle("Select Location");
                View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                dialogSp = view.findViewById(R.id.dialog_sp);
                dialog2Sp = view.findViewById(R.id.dialog2_sp);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AdsViewActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.locations));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dialogSp.setAdapter(adapter);


                dialogSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    ArrayAdapter<String> adapter;
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0){
                            adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.colombo));
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            dialog2Sp.setAdapter(adapter);
                        } else if (position ==1){
                            adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.matara));
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            dialog2Sp.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setView(view);
                builder.create().show();
            }
        });
    }
}