package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfilePicture extends AppCompatActivity {
    Button btnDescribeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_picture);
        btnDescribeActivity = findViewById(R.id.btnDescribeActivity);
        btnDescribeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDescribeActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ProfilePicture.this, DescribeActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
}
