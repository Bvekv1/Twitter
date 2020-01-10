package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpConfirm extends AppCompatActivity {
    TextInputEditText etName2, etEmail2;
    Button btnSignUpA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_confirm);
        etName2 = findViewById(R.id.etName2);
        etEmail2 = findViewById(R.id.etEmail2);
        btnSignUpA = findViewById(R.id.btnSignUpA);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            etName2.setText(bundle.getString("Name"));
            etEmail2.setText(bundle.getString("Email"));
        }
        btnSignUpA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpConfirm.this,CodeActivity.class);
                intent.putExtra("Name",etName2.getText().toString());
                intent.putExtra("Email",etEmail2.getText().toString());
                  startActivity(intent);
            }
        });
    }
}
