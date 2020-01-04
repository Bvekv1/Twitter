package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
         handler.postDelayed(new Runnable() {
             @Override
             public void run() {
                 splash();
             }
         },2000);
    }
    private  void splash(){
        Intent intent = new Intent(SplashActivity.this,FirstActivity.class);
        startActivity(intent);
    }
}
