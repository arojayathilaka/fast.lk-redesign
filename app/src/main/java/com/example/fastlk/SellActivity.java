package com.example.fastlk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.common.collect.Range;

import java.util.Calendar;

public class SellActivity extends AppCompatActivity {
    private Spinner transSp, fuelTySp, brandSp, modelSp;
    //EditText modelYrEt, mileageEt, engCapEt, priceEt;
    private Button postAdBtn;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        transSp = findViewById(R.id.trans_sp);
        fuelTySp = findViewById(R.id.fuel_ty_sp);
        brandSp = findViewById(R.id.brand_sp);
        modelSp = findViewById(R.id.model_sp);
        postAdBtn = findViewById(R.id.post_ad_btn);
//        modelYrEt = findViewById(R.id.model_yr_et);
//        mileageEt = findViewById(R.id.mileage_et);
//        engCapEt = findViewById(R.id.engine_cap_et);
//        priceEt = findViewById(R.id.price_et);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.model_yr_et, Range.closed(1900, Calendar.getInstance().get(Calendar.YEAR)), R.string.model_yr_error);
        awesomeValidation.addValidation(this, R.id.mileage_et, RegexTemplate.NOT_EMPTY, R.string.mileage_err);
        awesomeValidation.addValidation(this, R.id.engine_cap_et, RegexTemplate.NOT_EMPTY, R.string.eng_cap_err);
        awesomeValidation.addValidation(this, R.id.des_et, RegexTemplate.NOT_EMPTY, R.string.des_err);
        awesomeValidation.addValidation(this, R.id.price_et, RegexTemplate.NOT_EMPTY, R.string.price_err);
//        awesomeValidation.addValidation(this, R.id.trans_sp, RegexTemplate.NOT_EMPTY, R.string.price_err);

        ArrayAdapter<String> transAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.trans));
        transAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        transSp.setAdapter(transAdapter);

        ArrayAdapter<String> fuelTyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.fuel_ty));
        fuelTyAdapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        fuelTySp.setAdapter(fuelTyAdapter);

        ArrayAdapter<String> brandAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.brands));
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSp.setAdapter(brandAdapter);

        ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.models));
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSp.setAdapter(modelAdapter);

        postAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()){
                    Toast.makeText(SellActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}