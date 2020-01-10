package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class PasswordActivity extends AppCompatActivity {
  Button btnPassword;
    TextInputEditText etPassword;
    private String name,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        btnPassword = findViewById(R.id.btnPassword);
        etPassword =findViewById(R.id.etPassword);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            name =bundle.getString("Name");
            email = bundle.getString("email");
        }
       btnPassword.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this,ProfilePicture.class);
               intent.putExtra("Name", name);
               intent.putExtra("email",email);
               intent.putExtra("password",etPassword.getText().toString());
                startActivity(intent);
            }
        });
    }
}
