package com.example.fastlk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

    public void click2(View view) {
        startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
    }

    public void click3(View view) {
        startActivity(new Intent(MainActivity.this, LocCatActivity.class));
    }

    public void click4(View view) {
        startActivity(new Intent(MainActivity.this, AdsViewActivity.class));
    }
}


