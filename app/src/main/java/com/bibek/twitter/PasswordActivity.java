package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasswordActivity extends AppCompatActivity {
  Button btnPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        btnPassword = findViewById(R.id.btnPassword);
       btnPassword.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this,ProfilePicture.class);
                startActivity(intent);
            }
        });
    }
}
