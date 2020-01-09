package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpConfirm extends AppCompatActivity {

    Button btnSignUpA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_confirm);
        btnSignUpA= findViewById(R.id.btnSignUpA);
        btnSignUpA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpConfirm.this,CodeActivity.class);
                  startActivity(intent);
            }
        });
    }
}
